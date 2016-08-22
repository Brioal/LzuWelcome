package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.NewChildAdapter;
import com.brioal.lzuwelcome.entity.NewsEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * News ChildFragment
 * Created by brioal on 16-8-21.
 */

public class NewsChildFragment extends BaseFragment {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_5 = 5;

    @Bind(R.id.new_child_refreshLayout)
    SwipeRefreshLayout mRefreshLayout;
    @Bind(R.id.new_child_recyclerView)
    RecyclerView mRecyclerView;
    private int mType = 1;
    private List<NewsEntity> mList;
    private NewChildAdapter mAdapter;

    public static NewsChildFragment newInstance(int type) {
        NewsChildFragment fragment = new NewsChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initVar() {
        mType = getArguments().getInt("Type");
    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.fra_new_child, container, false);
        ButterKnife.bind(this, mRootView);
    }

    @Override
    public void loadDataLocal() {

    }

    @Override
    public void loadDataNet() {
        if (mList == null) {
            mList = new ArrayList<>();
        } else {
            mList.clear();
        }
        for (int i = 0; i < 10; i++) {
            mList.add(new NewsEntity("", "", 0, ""));
        }
        mHandler.sendEmptyMessage(TYPE_SET_VIEW);
    }

    @Override
    public void setView() {
        if (mAdapter == null) {
            mAdapter = new NewChildAdapter(mContext, mList);
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
