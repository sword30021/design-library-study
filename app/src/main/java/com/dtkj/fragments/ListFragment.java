package com.dtkj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dtkj.R;
import com.dtkj.adapters.RecyclerAdapter;
import com.dtkj.widgets.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sword on 16/10/3.
 */

public class ListFragment extends Fragment implements RefreshLayout.OnLoadListener {
    @BindView(R.id.list_recycler) RecyclerView mListRecycler;
    @BindView(R.id.layout_swipe_refresh) RefreshLayout mLayoutSwipeRefresh;
//    @BindView(R.id.layout_swipe_refresh) SwipeRefreshLayout mLayoutSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mListRecycler.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        final List<String> mData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mData.add("我是第" + (i + 1) + "个");
        }
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(mData);
        mListRecycler.setAdapter(recyclerAdapter);

        mLayoutSwipeRefresh.setColorSchemeResources(android.R.color.holo_blue_bright);
        mLayoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mData.add(0, "refresh");
                recyclerAdapter.notifyDataSetChanged();
                mLayoutSwipeRefresh.setRefreshing(false);
            }
        });
        mLayoutSwipeRefresh.setOnLoadListener(this);
    }

    @Override
    public void onLoad() {
        mLayoutSwipeRefresh.postDelayed(new Runnable() {

            @Override
            public void run() {
                // 更新数据

                // 更新完后调用该方法结束刷新
                mLayoutSwipeRefresh.setLoading(false);
            }
        }, 1000);
    }
}
