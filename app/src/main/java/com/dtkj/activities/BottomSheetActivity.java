package com.dtkj.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dtkj.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sword on 16/9/28.
 */

public class BottomSheetActivity extends AppCompatActivity {
    @BindView(R.id.tv_name) TextView mTvName;
    @BindView(R.id.layout_bottom_sheet) NestedScrollView mLayoutBottomSheet;
    @BindView(R.id.layout_coordinator) CoordinatorLayout mLayoutCoordinator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        ButterKnife.bind(this);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(mLayoutBottomSheet);
        mTvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
    }
}
