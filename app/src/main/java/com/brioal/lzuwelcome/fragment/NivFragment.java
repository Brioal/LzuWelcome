package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.NivViewPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brioal on 2016/8/17.
 */

public class NivFragment extends BaseFragment {

    private static NivFragment sMNivFragment;
    @Bind(R.id.niv_tv_position)
    TextView mTvPosition;
    @Bind(R.id.niv_tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.niv_viewPager)
    ViewPager mViewPager;

    public static NivFragment newInstance() {
        if (sMNivFragment == null) {
            sMNivFragment = new NivFragment();
        }
        return sMNivFragment;
    }

    @Override
    public void initVar() {

    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.fra_niv, container, false);
        ButterKnife.bind(this, mRootView);
        initViewPager();
    }

    private void initViewPager() {
        NivViewPagerAdapter adapter = new NivViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
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
