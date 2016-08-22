package com.brioal.lzuwelcome.entity;

/**
 * 消息实体类
 * Created by brioal on 16-8-21.
 */

public class MessageEntity {
    private int mFromUserID;
    private int mToUserID;
    private String mContent;
    private long mTime;

    public MessageEntity(int fromUserID, int toUserID, String content, long time) {
        mFromUserID = fromUserID;
        mToUserID = toUserID;
        mContent = content;
        mTime = time;
    }

    public int getFromUserID() {
        return mFromUserID;
    }

    public void setFromUserID(int fromUserID) {
        mFromUserID = fromUserID;
    }

    public int getToUserID() {
        return mToUserID;
    }

    public void setToUserID(int toUserID) {
        mToUserID = toUserID;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }
}
