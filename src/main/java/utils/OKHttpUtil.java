package utils;

import com.alibaba.fastjson.JSON;
import okhttp3.*;


public class OKHttpUtil {
    private static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * @param url             请求地址
     * @param requestBodyJson 请求体
     * @param mediaTypeStr    HTTP请求体的内容类型，如 "application/json; charset=utf-8"
     */
    public static void postMethod(String url, String requestBodyJson, String mediaTypeStr) throws Exception {
        RequestBody requestBody = RequestBody.create(JSON.toJSONString(requestBodyJson), MediaType.parse(mediaTypeStr));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
        System.out.println(response.code());
        System.out.println(response.header("status"));
    }

    public static void main(String[] args) throws Exception {

        String str = "UserTel=15167197827&UserPW2=123456&theme=8&sid=XIAOBAO-ERP-Pro-10.9_1a5b131e-011f-41b4-869a-1a64b88d3f4f&loginMode=phoneLogin";
        //String s = JSON.toJSONString(map);
        //System.out.println(s);
       // JSONObject jsonObject = JSON.parseObject(s);
        postMethod("https://pro.schoolpal.cn/sso/xb10/login?resumeUrl=%2fschoolpal%2fssosucceed&ssoFailedUrl=%2fschoolpal%2fssofailed",
                str,
                "application/x-www-form-urlencoded");
    }
}
