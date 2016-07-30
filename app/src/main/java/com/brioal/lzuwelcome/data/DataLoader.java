package com.brioal.lzuwelcome.data;

import android.content.Context;

import com.brioal.lzuwelcome.entity.User;

/**
 * Created by brioal on 16-7-30.
 */

public class DataLoader {
    private static DataLoader mLoader;
    private Context mContext;
    private static User mUser;


    public DataLoader(Context context) {
        mContext = context;
    }

    public static DataLoader instance(Context context) {
        if (mLoader == null) {
            mLoader = new DataLoader(context);
        }
        return mLoader;
    }

    public boolean isLogined() {
        if (mUser == null) {
            return false;
        }
        return true;
    }
}
