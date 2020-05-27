package utils;

import com.alibaba.fastjson.JSON;
import pojo.AssertPojo;
import pojo.updetaSignPassWordPojo.UpdateSignPwdTestData;

import java.lang.reflect.Field;

public class MakeRequestBodyStrUtil {
    public static void main(String[] args) throws Exception {
        UpdateSignPwdTestData updateSignPwdTestData = new UpdateSignPwdTestData("12345678", "123456", "1", new AssertPojo(200, "ssss"));
        /*String s = makeFromReqStr(updateSignPwdTestData);
        System.out.println(s);*/

        System.out.println(makeJsonReqStr(updateSignPwdTestData));

    }

    public static <T> String makeFromReqStr(T t) {
        StringBuilder stringBuilder = new StringBuilder(100);
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object o = null;
            try {
                o = declaredField.get(t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String name = declaredField.getName();
            stringBuilder.append(name + "=" + o + "&");
        }
        int i = stringBuilder.lastIndexOf("&");
        String str = stringBuilder.substring(0, i);

        return str;
    }

    public static <T> String makeJsonReqStr(T t) throws Exception {
        String s = JSON.toJSONString(t);
        return s;
    }
}
