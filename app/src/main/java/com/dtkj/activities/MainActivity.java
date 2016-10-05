package com.dtkj.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.dtkj.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
    NavigationView.OnNavigationItemSelectedListener, TextWatcher {

    @BindView(R.id.layout_left) NavigationView mLayoutLeft;
    @BindView(R.id.layout_drawer) DrawerLayout mLayoutDrawer;
    @BindView(R.id.btn_floating) FloatingActionButton mBtnFloating;
    @BindView(R.id.et_name) EditText mEtName;
    @BindView(R.id.layout_input) TextInputLayout mLayoutInput;
    @BindView(R.id.layout_coordinator) CoordinatorLayout mLayoutCoordinator;
    @BindView(R.id.layout_toolbar) Toolbar mLayoutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mLayoutLeft.setNavigationItemSelectedListener(this);
        mBtnFloating.setOnClickListener(this);
        mEtName.addTextChangedListener(this);
        mLayoutToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(mLayoutToolbar);
        mLayoutToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayoutDrawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.layout_toolbar:
                mLayoutDrawer.openDrawer(GravityCompat.START);
                break;
            case R.id.menu_recyclerview:
               startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.menu_tablayout:
                startActivity(new Intent(this, TabLayoutActivity.class));
                break;
            case R.id.menu_bottomsheet:
                startActivity(new Intent(this, BottomSheetActivity.class));
                break;
            case R.id.menu_flexbox:
                startActivity(new Intent(this, FlexBoxActivity.class));
                break;
            case R.id.menu_shader:
                startActivity(new Intent(this, BitmapShaderActivity.class));
                break;
            default:
                break;
        }
        mLayoutDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_floating:
                showSnackBar();
                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (count > 5) {
            mLayoutInput.setErrorEnabled(true);
            mLayoutInput.setError("一次输入不超过5个字符");
        } else {
            mLayoutInput.setErrorEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private void showSnackBar() {
        Snackbar.make(mLayoutCoordinator, getString(R.string.app_name), Snackbar.LENGTH_SHORT)
            .setAction("show left", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mLayoutDrawer.openDrawer(GravityCompat.START);
                }
            })
            .show();
    }
}
