package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.RecMsgAdapter;
import com.brioal.lzuwelcome.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 最近消息列表Fra
 * Created by brioal on 16-8-21.
 */

public class RecMsgFragment extends BaseFragment {
    private static RecMsgFragment sFragment;

    public static RecMsgFragment newInstance() {
        if (sFragment == null) {
            sFragment = new RecMsgFragment();
        }
        return sFragment;
    }

    @Bind(R.id.rec_msg_recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.rec_msg_refreshLayout)
    SwipeRefreshLayout mRefreshLayout;

    private List<MessageEntity> mList;
    private RecMsgAdapter mRecMsgAdapter;

    @Override
    public void initVar() {

    }

    @Override
    public void initView(Bundle saveInstanceState) {
        mRootView = inflater.inflate(R.layout.item_rec_msg_fra, container, false);
        ButterKnife.bind(this, mRootView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                loadRecMsg();
            }
        }).start();
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadRecMsg();
                    }
                }).start();
            }
        });
    }

    public void loadRecMsg() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(new MessageEntity(1, 1, "", 1));
        }
        mHandler.sendEmptyMessage(TYPE_SET_VIEW);
    }


    @Override
    public void loadDataLocal() {

    }

    @Override
    public void loadDataNet() {

    }

    @Override
    public void setView() {
        if (mRecMsgAdapter == null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mRecMsgAdapter = new RecMsgAdapter(mContext, mList);
            mRecyclerView.setAdapter(mRecMsgAdapter);
        } else {
            mRecMsgAdapter.notifyDataSetChanged();
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
