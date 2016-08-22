package com.brioal.lzuwelcome.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.entity.GuideEntity;
import com.brioal.lzuwelcome.fragment.GuideDetailFragment;
import com.brioal.lzuwelcome.view.TraView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brioal on 2016/8/17.
 */

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {

    private Context mContext;
    private List<GuideEntity> mList;

    public GuideAdapter(Context context, List<GuideEntity> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new GuideViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_guide, parent, false));
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, final int position) {
        holder.index.setIndex(position + 1);
        holder.title.setText(mList.get(position).getTitle());
        holder.desc.setText(mList.get(position).getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("Index", position);
                GuideDetailFragment fragment = new GuideDetailFragment();
                fragment.setArguments(bundle);
                fragment.show(((AppCompatActivity) mContext).getSupportFragmentManager(), "GuideDetail");
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    //内容
    class GuideViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.guide_tv_title)
        TextView title;
        @Bind(R.id.guide_tv_desc)
        TextView desc;
        @Bind(R.id.guide_tv_index)
        TraView index;

        View itemView;

        public GuideViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }

}
