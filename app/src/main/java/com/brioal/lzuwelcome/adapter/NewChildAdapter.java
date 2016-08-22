package com.brioal.lzuwelcome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.entity.NewsEntity;

import java.util.List;

/**
 * ChildFragment RecyclerView Adapter
 * Created by brioal on 16-8-21.
 */

public class NewChildAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<NewsEntity> mLists;

    public NewChildAdapter(Context context, List<NewsEntity> lists) {
        mContext = context;
        mLists = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_new, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    class NewViewHolder extends RecyclerView.ViewHolder {

        public NewViewHolder(View itemView) {
            super(itemView);
        }
    }
}
