package com.ustb.ssjgl.bean;

public class User {
    private String userName;
    private String passWord;
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public boolean getLocked() {
        // TODO Auto-generated method stub
        return false;
    }
    public byte[] getCredentialsSalt() {
        // TODO Auto-generated method stub
        return null;
    }
}
