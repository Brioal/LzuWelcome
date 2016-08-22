package com.brioal.lzuwelcome.base;

import com.brioal.baselib.base.BaseActivity;
import com.brioal.baselib.util.ToastUtils;
import com.brioal.net.callback.RequestCallback;

/**
 * Created by brioal on 16-7-30.
 */

public abstract class LzuBaseActivity extends BaseActivity {

    public abstract class LzuRequestCallBack implements RequestCallback {

        @Override
        public void onFail(String errorMessage) {

            ToastUtils.showToast(LzuBaseActivity.this, errorMessage);
        }
    }
}
