package utils;

import com.alibaba.fastjson.JSON;
import kotlin.Pair;
import okhttp3.*;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

//使用了cookiejar来自动对cookie信息进行保存 更新和携带

public class OKHttpUtil {

    private static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                @Override
                public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
                    cookieStore.put(url.host(),cookies);
                }

                @NotNull
                @Override
                public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
                    List<Cookie> cookies = cookieStore.get(httpUrl.host());
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            })
            .build();


    /**
     * @param url          请求地址
     * @param requestBody  请求体
     * @param mediaTypeStr HTTP请求体的内容类型，如 "application/json; charset=utf-8"
     */
    public static Response postMethod(String url, String requestBody, String mediaTypeStr) {


        RequestBody myRequestBody = RequestBody.create(requestBody, MediaType.parse(mediaTypeStr));
        Request request = new Request.Builder()
                .url(url)
                .post(myRequestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param url
     * @return
     * @throws Exception
     */
    public static Response getMethod(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
