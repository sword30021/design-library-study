package com.dtkj.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dtkj.R;
import com.dtkj.widgets.CustomCircleView;
import com.dtkj.widgets.CustomDialog;
import com.dtkj.widgets.CustomGifView;

import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sword on 16/10/3.
 */

public class BitmapShaderActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_dialog) CustomCircleView mBtnDialog;
    @BindView(R.id.gif_view) CustomGifView mGifView;
    private InputStream mInputStream;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_shader);
        ButterKnife.bind(this);
        mBtnDialog.setOnClickListener(this);
//        try {
//            mInputStream = getAssets().open("ic_gif_view.gif");
//            mGifView.setGifStream(mInputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog:
                DialogFragment dialogFragment = CustomDialog.newInstance(R.string.app_name);
                dialogFragment.show(getSupportFragmentManager(), "dialog");
                break;
            default:
                break;
        }
    }

    public void doPositiveClick() {
        Toast.makeText(this, "Positive click!", Toast.LENGTH_SHORT).show();
    }

    public void doNegativeClick() {
        Toast.makeText(this, "Negative click!", Toast.LENGTH_SHORT).show();
    }
}
