package com.brioal.lzuwelcome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.entity.MessageEntity;

import java.util.List;

/**
 * 最近消息列表RecyclerView Adapter
 * Created by brioal on 16-8-21.
 */

public class RecMsgAdapter extends RecyclerView.Adapter {
    private final int TYPE_MSG = 0;
    private final int TYPE_NODATA = 1;

    private Context mContext;
    private List<MessageEntity> mList;


    public RecMsgAdapter(Context context, List<MessageEntity> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_MSG) {
            return new MsgViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rec_message, parent, false));
        } else if (viewType == TYPE_NODATA) {
            return new NoDataViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rec_msg_nodata, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mList == null || mList.size() == 0) {
            return 1;
        }
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList == null || mList.size() == 0) {
            return TYPE_NODATA;
        }
        return TYPE_MSG;
    }

    //消息列表ViewHolder
    class MsgViewHolder extends RecyclerView.ViewHolder {

        public MsgViewHolder(View itemView) {
            super(itemView);
        }
    }

    //无最近消息列表ViewHolder
    class NoDataViewHolder extends RecyclerView.ViewHolder {

        public NoDataViewHolder(View itemView) {
            super(itemView);
        }
    }
}
