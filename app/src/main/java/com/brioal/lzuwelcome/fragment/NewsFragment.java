package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.baselib.util.ToastUtils;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.NewsViewPagerAdapter;
import com.brioal.lzuwelcome.entity.NewsBannerEntity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 校园资讯Fra
 * Created by brioal on 16-8-21.
 */

public class NewsFragment extends BaseFragment {
    private static NewsFragment sFragment;
    @Bind(R.id.news_banner)
    BGABanner mBanner;
    @Bind(R.id.news_tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.news_viewPager)
    ViewPager mViewPager;

    private List<NewsBannerEntity> mBannerList;
    private NewsViewPagerAdapter mViewPagerAdapter;

    public static NewsFragment newInstance() {
        if (sFragment == null) {
            sFragment = new NewsFragment();
        }
        return sFragment;
    }

    @Override
    public void initVar() {

    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.fra_news, container, false);
        ButterKnife.bind(this, mRootView);
        initViewPager();

    }

    private void initViewPager() {
        mViewPagerAdapter = new NewsViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initBanner() {
        mBannerList = new ArrayList<>();
        mBannerList.add(new NewsBannerEntity("", "", ""));
        mBannerList.add(new NewsBannerEntity("", "", ""));
        mBannerList.add(new NewsBannerEntity("", "", ""));
    }

    @Override
    public void loadDataLocal() {

    }

    @Override
    public void loadDataNet() {
        initBanner();
    }

    @Override
    public void setView() {
        setBannerView();
    }

    private void setBannerView() {
        if (mBannerList == null || mBannerList.size() < 2) {
            return;
        }
        List<View> views = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < mBannerList.size(); i++) {
            NewsBannerEntity entity = mBannerList.get(i);
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(mContext).load(R.mipmap.ic_user_back).into(imageView);
            views.add(imageView);
            strings.add(entity.getText());
        }
        mBanner.setData(views, strings);
        mBanner.setOnItemClickListener(new BGABanner.OnItemClickListener() {
            @Override
            public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
                ToastUtils.showToast(mContext, mBannerList.get(position).getUrl());
            }
        });
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
