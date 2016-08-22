package com.brioal.lzuwelcome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.brioal.lzuwelcome.fragment.NewsChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * News Fragment ViewPager Adapter
 * Created by brioal on 16-8-21.
 */

public class NewsViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mList;

    public NewsViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<>();
        mList.add("兰大特快");
        mList.add("寻物招领");
        mList.add("校园市场");
        mList.add("网络中心信箱");
        mList.add("重要通知");
    }

    @Override
    public Fragment getItem(int position) {

        return NewsChildFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
