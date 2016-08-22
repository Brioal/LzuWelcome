package com.brioal.lzuwelcome.activity;

import android.app.Application;

import com.brioal.net.cache.CacheManager;
import com.brioal.net.operator.NetService;

/**
 * Created by Brioal on 2016/8/16.
 */

public class LzuApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetService.inited(this, "apis.txt");
        CacheManager.getInstance().initCacheDir(this);
    }
}
