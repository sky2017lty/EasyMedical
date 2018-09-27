package com.study.litianyi.easymedical2;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class User extends LitePalSupport {
    private UUID mUserUUID;
    private String mUserName;
    private String mUserPhone;
    private String mUserPassWord;
    private String mUserAddress;

    public User(){
        mUserUUID = UUID.randomUUID();
    }

    public UUID getUserUUID() {
        return mUserUUID;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getUserPhone() {
        return mUserPhone;
    }

    public void setUserPhone(String userPhone) {
        mUserPhone = userPhone;
    }

    public String getUserAddress() {
        return mUserAddress;
    }

    public void setUserAddress(String userAddress) {
        mUserAddress = userAddress;
    }

    public String getUserPassWord() {
        return mUserPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        mUserPassWord = userPassWord;
    }
}
