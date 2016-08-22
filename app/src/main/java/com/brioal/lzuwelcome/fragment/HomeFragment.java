package com.brioal.lzuwelcome.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brioal.baselib.base.BaseFragment;
import com.brioal.lzuwelcome.R;
import com.brioal.lzuwelcome.adapter.GuideAdapter;
import com.brioal.lzuwelcome.entity.GuideEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页Fra
 * Created by Brioal on 2016/7/31.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.fra_rv_flow)
    RecyclerView mRvFlow;

    private static HomeFragment sFragment;

    public static HomeFragment newInstance() {
        if (sFragment == null) {
            sFragment = new HomeFragment();
        }
        return sFragment;
    }

    private GuideAdapter mGuideAdapter;
    private List<GuideEntity> mList;

    @Override
    public void initVar() {
    }

    @Override
    public void initView(Bundle bundle) {
        mRootView = inflater.inflate(R.layout.fra_home, container, false);
        ButterKnife.bind(this, mRootView);
        mList = new ArrayList<>();
        mList.add(new GuideEntity("到达兰州", "跟随接待人员引导"));
        mList.add(new GuideEntity("到达榆中校区", "找到各学院迎新点"));
        mList.add(new GuideEntity("领取相关物品", "校园卡，宿舍钥匙"));
        mList.add(new GuideEntity("入住宿舍", ""));
        mList.add(new GuideEntity("新生入学教育活动", "9月3日"));
        mList.add(new GuideEntity("新生开学典礼暨军训开训", "9月10日"));
        mList.add(new GuideEntity("基地班选拔考试", "9月12日"));
        mGuideAdapter = new GuideAdapter(getActivity(), mList);
        mRvFlow.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFlow.setAdapter(mGuideAdapter);
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
