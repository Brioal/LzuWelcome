package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.FriendAdapter;
import com.brioal.lzuwelcome.entity.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 好友列表Fragment
 * Created by brioal on 16-8-21.
 */

public class FriendFragment extends BaseFragment {
    @Bind(R.id.friend_refreshLayout)
    SwipeRefreshLayout mRefreshLayout;
    @Bind(R.id.friend_recyclerView)
    RecyclerView mRecyclerView;

    private List<User> mLists;
    private FriendAdapter mAdapter;
    private static FriendFragment sFragment;

    public static FriendFragment newInstance() {
        if (sFragment == null) {
            sFragment = new FriendFragment();
        }
        return sFragment;
    }

    @Override
    public void initVar() {

    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.fra_friend, container, false);
        ButterKnife.bind(this, mRootView);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadDataNet();
                    }
                }).start();
            }
        });
    }

    @Override
    public void loadDataLocal() {

    }

    @Override
    public void loadDataNet() {
        mLists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mLists.add(new User());
        }

        mHandler.sendEmptyMessage(TYPE_SET_VIEW);
    }

    @Override
    public void setView() {
        if (mAdapter == null) {
            mAdapter = new FriendAdapter(mContext, mLists);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void updateView() {

    }

    @Override
    public void saveDataLocal() {

    }
}
