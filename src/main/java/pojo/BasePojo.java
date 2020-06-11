package pojo;

import java.util.Arrays;

public class BasePojo<T> {
    private String url;

    T testData[];

    public BasePojo(String url, T[] testData) {
        this.url = url;
        this.testData = testData;
    }

    public BasePojo() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T[] getTestData() {
        return testData;
    }

    public void setTestData(T[] testData) {
        this.testData = testData;
    }

    @Override
    public String toString() {
        return "BasePojo{" +
                "url='" + url + '\'' +
                ", testData=" + Arrays.toString(testData) +
                '}';
    }
}
