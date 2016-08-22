package com.brioal.lzuwelcome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.brioal.lzuwelcome.fragment.BenBuNivFragment;
import com.brioal.lzuwelcome.fragment.YuZhongNivFragment;

/**
 * NivFragment ViewPager Adapter
 * Created by brioal on 16-8-22.
 */

public class NivViewPagerAdapter extends FragmentStatePagerAdapter {

    public NivViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return BenBuNivFragment.newInstance();
        } else if (position == 1) {
            return YuZhongNivFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "本部导航";
        } else if (position == 1) {
            return "榆中校区导航";
        }
        return super.getPageTitle(position);
    }
}
