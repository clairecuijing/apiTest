package pojo.base;

public class BaseTest {
    private String UserTel;
    private String UserPW2;
    private int theme;
    private String loginMode;
    private String UserPW;
    private String UserName;
    private String orgName;


    public BaseTest(String userTel, String userPW2, int theme, String loginMode, String userPW, String userName, String orgName) {
        UserTel = userTel;
        UserPW2 = userPW2;
        this.theme = theme;
        this.loginMode = loginMode;
        UserPW = userPW;
        UserName = userName;
        this.orgName = orgName;
    }

    public BaseTest() {
    }

    public String getUserTel() {
        return UserTel;
    }

    public void setUserTel(String userTel) {
        UserTel = userTel;
    }

    public String getUserPW2() {
        return UserPW2;
    }

    public void setUserPW2(String userPW2) {
        UserPW2 = userPW2;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(String loginMode) {
        this.loginMode = loginMode;
    }

    public String getUserPW() {
        return UserPW;
    }

    public void setUserPW(String userPW) {
        UserPW = userPW;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "BaseTest{" +
                "UserTel='" + UserTel + '\'' +
                ", UserPW2='" + UserPW2 + '\'' +
                ", theme='" + theme + '\'' +
                ", loginMode='" + loginMode + '\'' +
                ", UserPW='" + UserPW + '\'' +
                ", UserName='" + UserName + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
