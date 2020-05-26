package bases;


import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReadJsonUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static utils.OKHttpUtil.postMethod;


public class BaseTest {
    public static String baseTestURL = "https://pro.schoolpal.cn";

    /**
     * 测试其他接口的前提是：首先需要登录
     */
    @BeforeSuite
    public void baseTest() {
        Map map = new HashMap();
        map.put("UserTel", "15167197827");
        map.put("UserPW2", "12345678");
        map.put("theme", 8);
        map.put("loginMode", "computerLogin");
        map.put("UserPW","123456");
        map.put("UserName","叶飞");
        map.put("orgName","demotest01");

        Response response = postMethod(baseTestURL + "/sso/xb10/login?resumeUrl=%2fschoolpal%2fssosucceed&ssoFailedUrl=%2fschoolpal%2fssofailed",
                map,
                "application/x-www-form-urlencoded");
        Assert.assertEquals(response.code(),200,"响应码不是200，登录失败！");
    }


    /**
     * 数据提供者
     * @param clazz
     * @param method
     * @return
     */
    @DataProvider
    public Object[] dataProvider(Class clazz,Method method){
        String path = clazz.getSimpleName()+"/"+method.getName();
        Map[] maps = ReadJsonUtil.readJsonFileToMapArr(path);
        return maps;
    }
}
