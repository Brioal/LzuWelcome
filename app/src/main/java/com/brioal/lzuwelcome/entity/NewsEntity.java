package com.brioal.lzuwelcome.entity;

/**
 * News Fragment Item Entity
 * Created by brioal on 16-8-21.
 */

public class NewsEntity {
    private String mTitle; //标题
    private String mAuthor; //作者
    private int mReplyNum; //回复数量
    private String mTime; //发表时间

    public NewsEntity(String title, String author, int replyNum, String time) {
        mTitle = title;
        mAuthor = author;
        mReplyNum = replyNum;
        mTime = time;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public int getReplyNum() {
        return mReplyNum;
    }

    public void setReplyNum(int replyNum) {
        mReplyNum = replyNum;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }
}
