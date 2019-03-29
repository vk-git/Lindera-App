package com.linderaredux.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linderaredux.R;

import androidx.annotation.Nullable;

public class LinderaTextView extends LinearLayout {

    TextView textView;

    public LinderaTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, android.R.attr.textStyle);
    }

    public LinderaTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.textview, this);
        textView = findViewById(R.id.txtView);

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.TextView, defStyleAttr, 0);

        try {
            if (typedArray.hasValue(R.styleable.TextView_android_text)) {
                String str = typedArray.getString(R.styleable.TextView_android_text);
                textView.setText(str);
            }
            if (typedArray.hasValue(R.styleable.TextView_android_textSize)) {
                float textSize = typedArray.getDimension(R.styleable.TextView_android_textSize, 0);
                float dimensions = getResources().getDisplayMetrics().density;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize / dimensions);
            }
            if (typedArray.hasValue(R.styleable.TextView_android_textColor)) {
                int str = typedArray.getColor(R.styleable.TextView_android_textColor, 0);
                textView.setTextColor(str);
            }
            if (typedArray.hasValue(R.styleable.TextView_android_gravity)) {
                int gravity = typedArray.getInt(R.styleable.TextView_android_gravity, 0);
                textView.setGravity(gravity);
            }
        } finally {
            typedArray.recycle();
        }
    }
}
