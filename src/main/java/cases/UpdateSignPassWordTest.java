package cases;

import bases.BaseTest;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.updetaSignPassWordPojo.UpdateSignPwdTestData;
import utils.MakeRequestBodyStrUtil;
import utils.OKHttpUtil;


/**
 * 测试修改登录密码接口
 */
public class UpdateSignPassWordTest extends BaseTest {
    @Test(dataProvider = "dataProvider")
    public void updateSignPassWordpositiveTest(String url, UpdateSignPwdTestData testData) {
        Response response = OKHttpUtil.postMethod(baseTestURL + url, MakeRequestBodyStrUtil.makeFromReqStr(testData), "application/json;charset=UTF-8");
        Assert.assertEquals(response.message(), testData.getAnAssert().getMessage(), "响应消息不是OK，密码修改失败");
    }

    @Test(dataProvider = "dataProvider")
    public void updateSignPassWordNegativeTest(String url, UpdateSignPwdTestData testData) {
        Response response = OKHttpUtil.postMethod(baseTestURL + url, MakeRequestBodyStrUtil.makeFromReqStr(testData), "application/json;charset=UTF-8");

    }

}
