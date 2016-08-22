package com.brioal.lzuwelcome.entity;

/**
 * 资讯界面Banner实体类
 * Created by brioal on 16-8-21.
 */

public class NewsBannerEntity {
    private String mImageUrl; //图片链接
    private String mText; //文字内容
    private String mUrl; //文章链接


    public NewsBannerEntity(String imageUrl, String text, String url) {
        mImageUrl = imageUrl;
        mText = text;
        mUrl = url;
    }


    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
