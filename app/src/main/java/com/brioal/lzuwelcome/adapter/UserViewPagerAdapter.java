package com.brioal.lzuwelcome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.brioal.lzuwelcome.fragment.FriendFragment;
import com.brioal.lzuwelcome.fragment.RecMsgFragment;
import com.brioal.lzuwelcome.fragment.UserInfoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人中心ViewPager  Adapter
 * Created by brioal on 16-8-21.
 */

public class UserViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitles;

    public UserViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mTitles = new ArrayList<>();
        mTitles.add("个人信息");
        mTitles.add("最近联系");
        mTitles.add("我的好友");

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return UserInfoFragment.newInstance();
            case 1:
                return RecMsgFragment.newInstance();
            case 2:
                return FriendFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
