package com.dtkj.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.dtkj.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sword on 16/9/27.
 */

public class TabLayoutActivity extends AppCompatActivity {
    @BindView(R.id.layout_tab) TabLayout mLayoutTab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);
        mLayoutTab.setTabMode(TabLayout.MODE_FIXED);
        mLayoutTab.addTab(mLayoutTab.newTab().setText("Tab1"));
        mLayoutTab.addTab(mLayoutTab.newTab().setText("Tab2"));
        mLayoutTab.addTab(mLayoutTab.newTab().setText("Tab3"));
    }
}
