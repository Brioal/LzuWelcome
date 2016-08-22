package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.UserInfoAdapter;
import com.brioal.lzuwelcome.data.DataLoader;
import com.brioal.lzuwelcome.entity.User;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 个人信息详情Fra
 * Created by brioal on 16-8-21.
 */

public class UserInfoFragment extends BaseFragment {
    @Bind(R.id.user_info_recyclerView)
    RecyclerView mRecyclerView;

    private User mUser;


    private static UserInfoFragment sFragment;


    public static UserInfoFragment newInstance() {
        if (sFragment == null) {
            sFragment = new UserInfoFragment();
        }
        return sFragment;
    }

    @Override
    public void initVar() {
        mUser = DataLoader.newInstance(mContext).getUser();
    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.user_info_fra, container, false);
        ButterKnife.bind(this, mRootView);
        mUser = new User();
        UserInfoAdapter adapter = new UserInfoAdapter(mContext, mUser);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
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
