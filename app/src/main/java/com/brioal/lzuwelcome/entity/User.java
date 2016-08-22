package com.brioal.lzuwelcome.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * Created by brioal on 16-7-30.
 */

public class User implements Serializable {

    private String mName; //姓名
    private String mID; //校园卡号
    private String mYuanxi; //院系
    private String mZhuanye; //专业
    private String mNianji; //年纪
    private String mBanji; //班级
    private String mDesc; //描述
    private String mHeadImageUrl; //头像地址

    public User() {

    }
    public User(String name, String ID, String yuanxi, String zhuanye, String nianji, String banji, String desc, String headImageUrl) {
        mName = name;
        mID = ID;
        mYuanxi = yuanxi;
        mZhuanye = zhuanye;
        mNianji = nianji;
        mBanji = banji;
        mDesc = desc;
        mHeadImageUrl = headImageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getYuanxi() {
        return mYuanxi;
    }

    public void setYuanxi(String yuanxi) {
        mYuanxi = yuanxi;
    }

    public String getZhuanye() {
        return mZhuanye;
    }

    public void setZhuanye(String zhuanye) {
        mZhuanye = zhuanye;
    }

    public String getNianji() {
        return mNianji;
    }

    public void setNianji(String nianji) {
        mNianji = nianji;
    }

    public String getBanji() {
        return mBanji;
    }

    public void setBanji(String banji) {
        mBanji = banji;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getHeadImageUrl() {
        return mHeadImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        mHeadImageUrl = headImageUrl;
    }
}
