package pojo;

public class AssertPojo {
    private int code;
    private String message;

    public AssertPojo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AssertPojo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Assert{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
