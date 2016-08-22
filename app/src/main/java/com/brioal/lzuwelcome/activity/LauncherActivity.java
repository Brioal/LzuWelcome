package com.brioal.lzuwelcome.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brioal.baselib.util.SizeUtil;
import com.brioal.baselib.util.StatusBarUtils;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.base.LzuBaseActivity;
import com.brioal.lzuwelcome.data.DataLoader;
import com.brioal.lzuwelcome.entity.User;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

import static android.support.v4.view.ViewCompat.animate;

public class LauncherActivity extends LzuBaseActivity implements View.OnClickListener {

    @Bind(R.id.launcher_tv_msg)
    TextView mTvMsg;
    @Bind(R.id.launcher_msg_layout)
    LinearLayout mMsgLayout;
    @Bind(R.id.launcher_btn_login)
    Button mBtnLogin;
    @Bind(R.id.launcher_btn_tourist)
    Button mBtnTourist;
    @Bind(R.id.launcher_layout)
    LinearLayout mCenterLayout;
    private boolean isLogined = true; //是否已登陆
    @Bind(R.id.launcher_logo)
    ImageView mIvLogo;
    private boolean animationStarted = false;
    private int ITEM_DELAY = 200;
    boolean isRecovery = false;
    private User mUser;


    @Override
    public void initVar() {
        mUser = DataLoader.newInstance(mContext).getUser();
        if (mUser == null) {
            isLogined = false;
        } else {
            isLogined = true;
        }

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.LzuTheme_NoActionbar);
        setContentView(R.layout.act_launcher);
        StatusBarUtils.setTranslucent(this);
        ButterKnife.bind(this);
    }

    @Override
    public void initTheme() {

    }

    @Override
    public void loadDataLocal() {

    }

    @Override
    public void loadDataNet() {

    }

    @Override
    public void setView() {

    }

    @Override
    public void updateView() {

    }

    @Override
    public void saveDataLocal() {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus || animationStarted) {
            return;
        }
        startAnimation();
        super.onWindowFocusChanged(hasFocus);

    }

    public void startAnimation() {

        animate(mIvLogo).translationY(SizeUtil.Dp2Px(mContext, -150)).setStartDelay(500).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        int childCount = mCenterLayout.getChildCount();
        ViewPropertyAnimatorCompat viewAnimator = null;
        for (int i = 0; i < childCount; i++) {
            View view = mCenterLayout.getChildAt(i);
            if (view.getId() == R.id.launcher_msg_layout) {
                continue;
            }
            if (!(view instanceof Button)) { //文字动画
                viewAnimator = ViewCompat.animate(view).translationY(SizeUtil.Dp2Px(mContext, 40)).alpha(1.0f).setStartDelay(i * ITEM_DELAY + 500).setDuration(1000);
            } else { //按钮动画
                viewAnimator = animate(view).translationY(SizeUtil.Dp2Px(mContext, 60)).scaleX(1.0f).scaleY(1.0f).setStartDelay(i * ITEM_DELAY + 500).setDuration(1000);
            }
            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();

        }
        Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                loginLocal();
            }
        });

    }

    //开始登陆
    public void startLogin() {
        mBtnLogin.setText("取消");
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelLogin();
            }
        });
        mTvMsg.setText(mUser.getName() + "同学,欢迎回来.........");
        ViewCompat.animate(mBtnTourist).setStartDelay(600).setDuration(1000).translationYBy(SizeUtil.Dp2Px(mContext, 60)).alpha(0).setInterpolator(new AccelerateInterpolator()).start(); //隐藏游客按钮
        ViewCompat.animate(mBtnLogin).setStartDelay(600).setDuration(1000).translationYBy(SizeUtil.Dp2Px(mContext, 60)).setInterpolator(new AccelerateInterpolator()).start(); //隐藏游客按钮
        ViewCompat.animate(mMsgLayout).setStartDelay(1000).setDuration(1000).translationYBy(SizeUtil.Dp2Px(mContext, 40)).alpha(1).setInterpolator(new DecelerateInterpolator()).setListener(new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {
            }

            @Override
            public void onAnimationEnd(View view) {
                Observable.timer(1500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        if (!isRecovery) {
                            MainActivity.startActivity(mContext, MainActivity.class);
                            finish();
                        }
                    }
                });
            }

            @Override
            public void onAnimationCancel(View view) {

            }
        }).start();
    }

    //取消登陆
    public void cancelLogin() {
        mBtnLogin.setText("登陆");
        isRecovery = true;
        //隐藏信息面板
        ViewCompat.animate(mMsgLayout).setStartDelay(100).setDuration(1000).translationYBy(-SizeUtil.Dp2Px(mContext, 60)).alpha(0).setInterpolator(new AccelerateInterpolator()).start();
        //游客按钮恢复
        ViewCompat.animate(mBtnTourist).setStartDelay(100).setDuration(1000).translationYBy(-SizeUtil.Dp2Px(mContext, 60)).alpha(1).setInterpolator(new AccelerateInterpolator()).start();
        //登陆按钮恢复
        ViewCompat.animate(mBtnLogin).setStartDelay(100).setDuration(1000).translationYBy(-SizeUtil.Dp2Px(mContext, 60)).setInterpolator(new AccelerateInterpolator()).start(); //隐藏游客按钮
        mBtnLogin.setOnClickListener(LauncherActivity.this);
    }

    //登陆操作
    public void loginLocal() {
        if (isLogined) { //已登陆
            startLogin();
        } else { //未登陆
            mBtnLogin.setOnClickListener(this);
            mBtnTourist.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.launcher_btn_login:
                LoginActivity.startActivity(mContext, LoginActivity.class);
                break;
            case R.id.launcher_btn_tourist:
                MainActivity.startActivity(mContext, MainActivity.class);
                finish();
                break;
        }
    }
}
