package utils;

import com.alibaba.fastjson.JSON;
import kotlin.Pair;
import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class OKHttpUtil {
    private static final String FIRST_REQUEST_URL = "https://pro.schoolpal.cn/";
    private static Logger logger = Logger.getLogger(OkHttpClient.class);
    public static String cookie;
    private static OkHttpClient okHttpClient = new OkHttpClient();

    static {
        setCookie(FIRST_REQUEST_URL);
    }

    /**
     * @param url          请求地址
     * @param requestBody  请求体
     * @param mediaTypeStr HTTP请求体的内容类型，如 "application/json; charset=utf-8"
     */
    public static Response postMethod(String url, String requestBody, String mediaTypeStr) {

        RequestBody myRequestBody = RequestBody.create(requestBody, MediaType.parse(mediaTypeStr));
        Request request = new Request.Builder()
                .header("cookie", cookie)
                .url(url)
                .post(myRequestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            return call.execute();
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
                .header("cookie", cookie)
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void setCookie(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        List<String> headers1 = null;
        try {
            headers1 = call.execute().headers("set-cookie");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cookie = String.join(",", headers1);
    }

}
