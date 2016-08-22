package com.brioal.lzuwelcome.entity;

/**
 * Created by Brioal on 2016/8/17.
 */

public class GuideEntity {
    private String mTitle;
    private String mDesc;

    public GuideEntity(String title, String desc) {
        mTitle = title;
        mDesc = desc;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }
}
