package com.brioal.lzuwelcome.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.brioal.baselib.util.SizeUtil;
import com.brioal.baselib.util.StatusBarUtils;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.base.LzuBaseActivity;
import com.brioal.lzuwelcome.data.DataLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.support.v4.view.ViewCompat.animate;

public class ActMainActivity extends LzuBaseActivity {

    private boolean isLogined = false; //是否已登陆
    @Bind(R.id.launcher_logo)
    ImageView mIvLogo;
    @Bind(R.id.launcher_layout)
    LinearLayout mLayout;
    private boolean animationStarted = false;
    private int ITEM_DELAY = 200;

    @Override
    public void initData() {
        super.initData();
        isLogined = DataLoader.instance(mContext).isLogined();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionbar);
        setContentView(R.layout.act_main);
        StatusBarUtils.setTranslucent(this);
        ButterKnife.bind(this);

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
        int child = mLayout.getChildCount();
        for (int i = 0; i < child; i++) {
            View view = mLayout.getChildAt(i);
            ViewPropertyAnimatorCompat viewAnimator = null;
            if (!(view instanceof Button)) { //文字动画
                viewAnimator = ViewCompat.animate(view).translationY(SizeUtil.Dp2Px(mContext, 40)).alpha(1.0f).setStartDelay(i * ITEM_DELAY + 500).setDuration(1000);
            } else { //按钮动画
                viewAnimator = animate(view).translationY(SizeUtil.Dp2Px(mContext, 60)).scaleX(1.0f).scaleY(1.0f).setStartDelay(i * ITEM_DELAY + 500).setDuration(1000);
            }
            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }

    }

}
