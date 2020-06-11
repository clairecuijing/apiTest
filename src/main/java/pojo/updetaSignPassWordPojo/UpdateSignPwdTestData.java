package pojo.updetaSignPassWordPojo;

import pojo.AssertPojo;

public class UpdateSignPwdTestData {
    private String newPassWord;
    private String oldPassWord;
    private String pwdStrength;
    private AssertPojo anAssert;

    public UpdateSignPwdTestData(String newPassWord, String oldPassWord, String pwdStrength, AssertPojo anAssert) {
        this.newPassWord = newPassWord;
        this.oldPassWord = oldPassWord;
        this.pwdStrength = pwdStrength;
        this.anAssert = anAssert;
    }


    public UpdateSignPwdTestData() {
    }

    public String getNewPassWord() {
        return newPassWord;
    }

    public void setNewPassWord(String newPassWord) {
        this.newPassWord = newPassWord;
    }

    public String getOldPassWord() {
        return oldPassWord;
    }

    public void setOldPassWord(String oldPassWord) {
        this.oldPassWord = oldPassWord;
    }

    public String getPwdStrength() {
        return pwdStrength;
    }

    public void setPwdStrength(String pwdStrength) {
        this.pwdStrength = pwdStrength;
    }

    public AssertPojo getAnAssert() {
        return anAssert;
    }

    public void setAnAssert(AssertPojo anAssert) {
        this.anAssert = anAssert;
    }

    @Override
    public String toString() {
        return "UpdateSignPwdTestData{" +
                "newPassWord='" + newPassWord + '\'' +
                ", oldPassWord='" + oldPassWord + '\'' +
                ", pwdStrength='" + pwdStrength + '\'' +
                ", anAssert=" + anAssert +
                '}';
    }
}
