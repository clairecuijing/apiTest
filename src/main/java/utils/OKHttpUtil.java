package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import kotlin.Pair;
import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class OKHttpUtil {
    private static final String GET_SESSION_URL= "https://pro.schoolpal.cn/";
    private static Logger logger =Logger.getLogger(OkHttpClient.class);
    private static String sessionId;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    static{
        setSessionId(getMethod(GET_SESSION_URL));
    }

    /**
     * @param url             请求地址
     * @param requestBody 请求体
     * @param mediaTypeStr    HTTP请求体的内容类型，如 "application/json; charset=utf-8"
     */
    public static Response postMethod(String url, Map requestBody, String mediaTypeStr) {
        //TODO:封装成专门的方法
        requestBody.put("sid",sessionId);
        RequestBody myRequestBody = null;
        final String[] reqStr = {""};
        if (mediaTypeStr.contains("application/json")){
            reqStr[0] =JSON.toJSONString(requestBody);
            myRequestBody = RequestBody.create(reqStr[0],MediaType.parse(mediaTypeStr));
        }else if (mediaTypeStr.contains("application/x-www-form-urlencoded")){
            requestBody.forEach((a,b)->{
                reqStr[0] += a+"="+b+"&";
            });
            if (reqStr[0].length() >0){
                int i =reqStr[0] .lastIndexOf("&");
                reqStr[0] = reqStr[0].substring(0,i);
                logger.info("请求体为"+reqStr[0]);
            }
            myRequestBody = RequestBody.create(reqStr[0], MediaType.parse(mediaTypeStr));
        }
        Request request = new Request.Builder()
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
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static Response getMethod(String url){
        Request request = new Request.Builder()
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

    private static void setSessionId(Response response){
        Headers headers = response.headers();
        Iterator<Pair<String, String>> iterator = headers.iterator();
        while(iterator.hasNext()){
            Pair<String, String> next = iterator.next();
            String str = null;
            if ("Set-Cookie".equals(next.getFirst()) && (str =next.getSecond()).contains("SessionId=")){
                int i = str.indexOf(";");
                sessionId = str.substring(str.indexOf("SessionId=")+10,i);
            }
        }
    }

}
