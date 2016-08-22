package com.brioal.lzuwelcome.entity;

/**
 * Niv Item Entity
 * Created by brioal on 16-8-22.
 */

public class NivPoint {
    private String mID;
    private String mTitle;
    private double mX;
    private double mY;

    public NivPoint(String ID, String title, double x, double y) {
        mID = ID;
        mTitle = title;
        mX = x;
        mY = y;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getX() {
        return mX;
    }

    public void setX(double x) {
        mX = x;
    }

    public double getY() {
        return mY;
    }

    public void setY(double y) {
        mY = y;
    }
}
