package com.dtkj.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.dtkj.R;
import com.dtkj.adapters.FragmentAdapter;
import com.dtkj.fragments.ListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sword on 16/9/28.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.layout_toolbar) Toolbar mLayoutToolbar;
    @BindView(R.id.layout_tab) TabLayout mLayoutTab;
    @BindView(R.id.layout_bar) AppBarLayout mLayoutBar;
    @BindView(R.id.layout_main) CoordinatorLayout mLayoutMain;
    @BindView(R.id.viewpager) ViewPager mViewpager;
    @BindView(R.id.backdrop) ImageView mBackdrop;
    @BindView(R.id.collapsing) CollapsingToolbarLayout mCollapsing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        setSupportActionBar(mLayoutToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mLayoutToolbar.setTitle(R.string.app_name);
        mLayoutToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        initBars();
        mCollapsing.setTitle("Title");
    }

    private void initBars() {
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        titles.add("购物");
        titles.add("明星");
        titles.add("视频");
        titles.add("健康");
        titles.add("励志");
        titles.add("图文");
        titles.add("本地");
        titles.add("动漫");
        titles.add("搞笑");
        titles.add("精选");
        for (int i = 0; i < titles.size(); i++) {
            mLayoutTab.addTab(mLayoutTab.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListFragment());
        }
        FragmentAdapter mFragmentAdapteradapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewpager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mLayoutTab.setupWithViewPager(mViewpager);
        //给TabLayout设置适配器
        mLayoutTab.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }

}
