package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import org.apache.commons.io.FileUtils;
import pojo.BasePojo;
import pojo.base.BaseTest;
import pojo.updetaSignPassWordPojo.UpdateSignPwdTestData;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;


public class ReadJsonUtil {
    private static final String PREFIX_PATH = "/testData/";
    private static final String SUFFIX_PATH = ".JSON";

    /**
     * Example
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        BasePojo basePojo = readJsonToPojo("UpdateSignPassWordTest/updateSignPassWordpositiveTest", new Type[]{UpdateSignPwdTestData.class},BasePojo.class);
        System.out.println(basePojo);
    }


    public static <T> T readJsonToPojo(String path, Type[] actureArguments,Type rawType) {
        URL resource = ReadJsonUtil.class.getResource(PREFIX_PATH + path + SUFFIX_PATH);
        File file = new File(resource.getPath());
        String s = null;
        try {
            s = FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Type type = new ParameterizedTypeImpl(actureArguments,null,rawType);
        return JSON.parseObject(s, type);
    }

}
