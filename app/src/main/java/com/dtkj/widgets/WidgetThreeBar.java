package com.dtkj.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dtkj.R;

/**
 * Created by sword on 16/9/28.
 */

public class WidgetThreeBar extends LinearLayout {
    private ImageView itemIcon;
    private TextView itemContent;
    private ImageView itemArrow;

    public WidgetThreeBar(Context context) {
        super(context);
    }

    public WidgetThreeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidget(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.widget_three_bar);
        Drawable drawable = typedArray.getDrawable(R.styleable.widget_three_bar_leftIcon);
        String text = typedArray.getString(R.styleable.widget_three_bar_centerText);
        Drawable arrow = typedArray.getDrawable(R.styleable.widget_three_bar_rightIcon);
        itemIcon.setImageDrawable(drawable);
        itemContent.setText(text);
        itemArrow.setImageDrawable(arrow);
        typedArray.recycle();
    }

    public WidgetThreeBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initWidget(Context context) {
        View.inflate(context, R.layout.widget_three_bar, this);
        itemIcon = (ImageView) findViewById(R.id.item_icon);
        itemContent = (TextView) findViewById(R.id.item_content);
        itemArrow = (ImageView) findViewById(R.id.item_arrow);
    }

}
