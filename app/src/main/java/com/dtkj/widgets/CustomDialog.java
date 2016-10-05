package com.dtkj.widgets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.dtkj.R;
import com.dtkj.activities.BitmapShaderActivity;

/**
 * Created by sword on 16/10/3.
 */

public class CustomDialog extends DialogFragment {

    public static CustomDialog newInstance(int title) {
        CustomDialog customDialog = new CustomDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        customDialog.setArguments(args);
        return customDialog;
    }

    /**
     * DialogFragment需要实现onCreateView或者onCreateDIalog方法。
     * onCreateView():使用定义的xml布局文件展示Dialog。
     * onCreateDialog():利用AlertDialog或者Dialog创建出Dialog。
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");
        return new AlertDialog.Builder(getActivity())//创建一个Dialog
            .setIcon(R.mipmap.ic_launcher)//设置图标
            .setTitle(title)//设置标题
            .setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {//确认（OK）按钮
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        ((BitmapShaderActivity) getActivity())
                            .doPositiveClick();
                    }
                })
            .setNegativeButton(android.R.string.cancel,//取消（Cancel）按钮
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        ((BitmapShaderActivity) getActivity())
                            .doNegativeClick();
                    }
                }).create();
    }
}

