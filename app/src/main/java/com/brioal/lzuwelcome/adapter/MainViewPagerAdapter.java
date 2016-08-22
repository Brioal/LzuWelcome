package com.brioal.lzuwelcome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.brioal.lzuwelcome.fragment.HomeFragment;
import com.brioal.lzuwelcome.fragment.NewsFragment;
import com.brioal.lzuwelcome.fragment.NivFragment;
import com.brioal.lzuwelcome.fragment.UserFragment;

/**
 * 主页ViewPager Adapter
 * Created by brioal on 16-8-21.
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeFragment.newInstance();
            case 1:
                return NivFragment.newInstance();
            case 2:
                return NewsFragment.newInstance();
            case 3:
                return UserFragment.newInstance();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
