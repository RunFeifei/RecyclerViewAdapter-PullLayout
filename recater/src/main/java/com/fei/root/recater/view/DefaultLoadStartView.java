package com.fei.root.recater.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fei.root.recater.R;


/**
 * Created by PengFeifei on 17-7-19.
 */

public class DefaultLoadStartView extends LinearLayout {

    protected TextView textView;
    protected ImageView imageView;

    public DefaultLoadStartView(Context context) {
        super(context);
        init(context, null);
    }

    public DefaultLoadStartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    protected void init(Context context, @Nullable AttributeSet attrs) {
        setGravity(Gravity.BOTTOM);
        setOrientation(HORIZONTAL);
        setBackgroundColor(Color.WHITE);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 500));

        LayoutParams layoutParams = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
        layoutParams.gravity = Gravity.CENTER;

        textView = new TextView(context);
        textView.setTextSize(15);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(50, 0, 0, 0);


        imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        imageView.setPadding(0, 0, 50, 0);


        textView.setText("释放刷新");
        imageView.setImageResource(R.drawable.ic_arrow);

        addView(imageView);
        addView(textView);
    }

    private void setViewContent(CharSequence text, @DrawableRes int resId) {
        textView.setText(text);
        imageView.setImageResource(resId);
    }


}
