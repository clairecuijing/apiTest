package bases;

import okhttp3.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pojo.BasePojo;
import pojo.updetaSignPassWordPojo.UpdateSignPwdTestData;
import utils.MakeRequestBodyStrUtil;
import utils.OKHttpUtil;
import utils.ReadJsonUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;



public class BaseTest {
    public static String baseTestURL = "https://pro.schoolpal.cn";

    /**
     * 测试其他接口的前提是：首先需要登录
     */
    @BeforeSuite
    public void baseTest() {
        BasePojo bs =(BasePojo) ReadJsonUtil.readJsonToPojo("BaseTest/baseTest", new Type[]{pojo.base.BaseTest.class}, BasePojo.class);
        String s = MakeRequestBodyStrUtil.makeFromReqStr(bs.getTestData()[0]);
       Response response = OKHttpUtil.postMethod(baseTestURL+bs.getUrl() ,s,
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
        System.out.println(basePojo);

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
