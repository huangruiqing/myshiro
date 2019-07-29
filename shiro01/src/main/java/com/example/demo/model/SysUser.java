package com.example.demo.model;

/**
 * @ClassName SysUser
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 15:52
 */
public class SysUser {
    private Long id;
    private String userName;
    private String userAccount;
    private String password;
    private String passwdSalt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswdSalt() {
        return passwdSalt;
    }

    public void setPasswdSalt(String passwdSalt) {
        this.passwdSalt = passwdSalt;
    }
}