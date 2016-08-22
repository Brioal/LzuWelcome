package com.brioal.lzuwelcome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.entity.User;

import java.util.List;

/**
 * Friend RecyclerView Adapter
 * Created by brioal on 16-8-21.
 */

public class FriendAdapter extends RecyclerView.Adapter {

    private final int TYPE_USER = 0;
    private final int TYPE_NODATA = 1;

    private Context mContext;
    private List<User> mList;

    public FriendAdapter(Context context, List<User> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NODATA) {
            return new NoDataViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_friend_nodata, parent, false));
        } else if (viewType == TYPE_USER) {
            return new UserViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_friend, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mList == null || mList.size() == 0) {
            return 0;
        }
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList == null || mList.size() == 0) {
            return TYPE_NODATA;
        }
        return TYPE_USER;
    }

    //好友Item
    private class UserViewHolder extends RecyclerView.ViewHolder {

        public UserViewHolder(View itemView) {
            super(itemView);
        }
    }

    //没有好友的界面
    private class NoDataViewHolder extends RecyclerView.ViewHolder {

        public NoDataViewHolder(View itemView) {
            super(itemView);
        }
    }
}
