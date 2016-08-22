package com.brioal.lzuwelcome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.entity.User;

/**
 * 用户详情界面RecyclerView Adapter
 * Created by brioal on 16-8-21.
 */

public class UserInfoAdapter extends RecyclerView.Adapter {
    private final int TYPE_INFO = 0;
    private final int TYPE_NODATA = 1;
    private Context mContext;
    private User mUser;


    public UserInfoAdapter(Context context, User user) {
        mContext = context;
        mUser = user;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_INFO) {
            return new UserInfoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_user_info_nodata, parent, false));
        } else if (viewType == TYPE_NODATA) {
            return new NoDataViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_user_info, parent, false));
        }
        return new UserInfoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_friend, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return mUser == null ? 0 : 1;
    }

    //个人信息ViewHolder
    class UserInfoViewHolder extends RecyclerView.ViewHolder {
        public UserInfoViewHolder(View itemView) {
            super(itemView);
        }
    }

    //未完善信息的ViewHolder
    class NoDataViewHolder extends RecyclerView.ViewHolder {

        public NoDataViewHolder(View itemView) {
            super(itemView);
        }
    }
}
