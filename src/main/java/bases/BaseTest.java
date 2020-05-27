package bases;

import okhttp3.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pojo.BasePojo;
import utils.MakeRequestBodyStrUtil;
import utils.OKHttpUtil;
import utils.ReadJsonUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;



public class BaseTest {
    public static String baseTestURL = "";

    /**
     * 测试其他接口的前提是：首先需要登录
     */
    @BeforeSuite
    public void baseTest() {
        String s = MakeRequestBodyStrUtil.makeFromReqStr(ReadJsonUtil.readJsonToPojo("BaseTest/baseTest",new Type[]{pojo.base.BaseTest.class},BasePojo.class));

       Response response = OKHttpUtil.postMethod(baseTestURL + "/sso/xb10/login?resumeUrl=%2fschoolpal%2fssosucceed&ssoFailedUrl=%2fschoolpal%2fssofailed",
                s,
                "application/x-www-form-urlencoded");
}


    /**
     * 数据提供者
     * @param clazz
     * @param method
     * @return
     */
    @DataProvider
    public Object[][] dataProvider(Class clazz,Method method) {
        String path = clazz.getSimpleName() + "/" + method.getName();
        int parameterCount = method.getParameterCount();//参数个数
        Parameter[] parameters = method.getParameters();

        Class<?> type = parameters[parameterCount - 1].getType();

        BasePojo basePojo = ReadJsonUtil.readJsonToPojo(path, new Type[]{type}, BasePojo.class);

        String url = basePojo.getUrl();
        Object[] testData = basePojo.getTestData();


        Object[][] objects = new Object[testData.length][2];
        for (int i = 0; i < testData.length; i++) {
            objects[i][0]=url;
            objects[i][1] = testData[i];
        }
        return objects;

    }
}
