package com.brioal.lzuwelcome.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.baselib.util.BlurUtil;
import com.brioal.circleimage.CircleImageView;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.UserViewPagerAdapter;
import com.brioal.lzuwelcome.data.DataLoader;
import com.brioal.lzuwelcome.entity.User;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 个人中心Fra
 * Created by brioal on 16-8-21.
 */

public class UserFragment extends BaseFragment {
    private static UserFragment sFragment;
    @Bind(R.id.user_iv_head)
    CircleImageView mIvHead;
    @Bind(R.id.user_tv_name)
    TextView mTvName;
    @Bind(R.id.user_tv_desc)
    TextView mTvDesc;
    @Bind(R.id.user_head_layout)
    LinearLayout mHeadLayout;
    @Bind(R.id.user_tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.user_view_pager)
    ViewPager mViewPager;

    private User mUser;

    public static UserFragment newInstance() {
        if (sFragment == null) {
            sFragment = new UserFragment();
        }

        return sFragment;
    }

    @Override
    public void initVar() {
        mUser = DataLoader.newInstance(mContext).getUser();
    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.user_fra, container, false);
        ButterKnife.bind(this, mRootView);
        initHeadLayout();
        initViewPager();
    }

    private void initViewPager() {
        UserViewPagerAdapter adapter = new UserViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        initTabLayout();
    }


    private void initTabLayout() {

    }

    private void initHeadLayout() {
        Bitmap back = BlurUtil.fastblur(mContext, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_user_back), 0.7f, 20);
        mHeadLayout.setBackground(new BitmapDrawable(back));
        if (mUser != null) {
            mTvName.setText(mUser.getName());
        }
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
