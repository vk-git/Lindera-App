package com.linderaredux.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

import com.linderaredux.R

class LinderaTextView : LinearLayout {

    private lateinit var textView: TextView

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs, android.R.attr.textStyle)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.textview, this)
        textView = findViewById(R.id.txtView)

        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.TextView, defStyleAttr, 0)

        try {
            if (typedArray.hasValue(R.styleable.TextView_android_text)) {
                val str = typedArray.getString(R.styleable.TextView_android_text)
                textView.text = str
            }
            if (typedArray.hasValue(R.styleable.TextView_android_textSize)) {
                val textSize = typedArray.getDimension(R.styleable.TextView_android_textSize, 0f)
                val dimensions = resources.displayMetrics.density
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize / dimensions)
            }
            if (typedArray.hasValue(R.styleable.TextView_android_textColor)) {
                val str = typedArray.getColor(R.styleable.TextView_android_textColor, 0)
                textView.setTextColor(str)
            }
            if (typedArray.hasValue(R.styleable.TextView_android_gravity)) {
                val gravity = typedArray.getInt(R.styleable.TextView_android_gravity, 0)
                textView.gravity = gravity
            }
        } finally {
            typedArray.recycle()
        }
    }
}
