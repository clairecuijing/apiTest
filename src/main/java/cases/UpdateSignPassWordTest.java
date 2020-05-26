package cases;

import bases.BaseTest;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.OKHttpUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试修改登录密码接口
 */
public class UpdateSignPassWordTest extends BaseTest {
    @Test(dataProvider = "dataProvider")
    public void updateSignPassWordpositiveTest(Map map){
       Response response = OKHttpUtil.postMethod(baseTestURL + "/Home/UserCenterChangePassWord", map, "application/json;charset=UTF-8");
        Assert.assertEquals(response.code(),200,"响应码不是200，密码修改失败！");
    }

    @Test(dataProvider = "dataProvider")
    public void updateSignPassWordNegativeTest(Map map){
        Response response = OKHttpUtil.postMethod(baseTestURL + "/Home/UserCenterChangePassWord", map, "application/json;charset=UTF-8");
    }


}
