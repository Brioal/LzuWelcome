package com.brioal.lzuwelcome.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.brioal.bottomtab.entity.TabEntity;
import com.brioal.bottomtab.interfaces.OnTabSelectedListener;
import com.brioal.bottomtab.view.BottomLayout;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.MainViewPagerAdapter;
import com.brioal.lzuwelcome.base.LzuBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends LzuBaseActivity implements View.OnClickListener {


    @Bind(R.id.main_viewPager)
    ViewPager mViewPager;
    @Bind(R.id.main_bottom_tab)
    BottomLayout mBottomTab;

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initVar() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        initViewPager();
        initBottomTab();
    }

    private void initViewPager() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mainViewPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomTab.setCurrentIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initBottomTab() {
        List<TabEntity> list = new ArrayList<>();
        list.add(new TabEntity(R.mipmap.ic_guide, "新生报道"));
        list.add(new TabEntity(R.mipmap.ic_map, "校园导航"));
        list.add(new TabEntity(R.mipmap.ic_new, "校园资讯"));
        list.add(new TabEntity(R.mipmap.ic_people, "个人中心"));
        mBottomTab.setList(list);
        mBottomTab.setSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int i) {
                mViewPager.setCurrentItem(i);
            }
        });
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
}
