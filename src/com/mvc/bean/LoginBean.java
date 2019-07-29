package com.mvc.bean;

public class LoginBean {

    private String uname;
    private String upsd;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpsd() {
        return upsd;
    }

    public void setUpsd(String upsd) {
        this.upsd = upsd;
    }

    public LoginBean(String uname, String upsd) {
        this.uname = uname;
        this.upsd = upsd;
    }
}
