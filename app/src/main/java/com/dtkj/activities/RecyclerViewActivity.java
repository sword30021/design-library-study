package com.dtkj.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.dtkj.R;
import com.dtkj.adapters.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sword on 16/9/28.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.list_recycler) RecyclerView mListRecycler;
    @BindView(R.id.layout_swipe_refresh) SwipeRefreshLayout mLayoutSwipeRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
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
    }
}
