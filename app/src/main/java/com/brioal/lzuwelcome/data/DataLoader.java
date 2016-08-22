package com.brioal.lzuwelcome.data;

import android.content.Context;

import com.brioal.lzuwelcome.entity.User;
import com.brioal.lzuwelcome.util.SerializeUtil;

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

    public static DataLoader newInstance(Context context) {
        if (mLoader == null) {
            mLoader = new DataLoader(context);
        }
        return mLoader;
    }

    //是否登陆
    public boolean isLogined() {
        if (mUser == null) {
            return false;
        }
        return true;
    }

    //获取当前用户
    public User getUser() {
        if (mUser == null) {
            mUser = (User) SerializeUtil.deSerialization(mContext, "User", "User");
        }
        return mUser;
    }

    //保存用户到本地
    public boolean saveUserInfoLocal(User user) {
        return SerializeUtil.serialize(mContext, "User", "User", user);
    }
}
