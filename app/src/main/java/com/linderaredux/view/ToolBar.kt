package com.linderaredux.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.linderaredux.R
import com.linderaredux.extensions.gone
import com.linderaredux.extensions.visible

class ToolBar : LinearLayout {

    private lateinit var toolbarLeftButton: ImageView
    private lateinit var toolbarTitle: TextView
    private lateinit var txtRight: TextView

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs, android.R.attr.textViewStyle)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.toolbar, this)
        toolbarLeftButton = findViewById(R.id.toolbarLeftButton)
        toolbarTitle = findViewById(R.id.toolbar_title)
        txtRight = findViewById(R.id.txtRight)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ToolBar, defStyleAttr, 0)

        try {
            if (typedArray.hasValue(R.styleable.ToolBar_android_text)) {
                val str = typedArray.getString(R.styleable.ToolBar_android_text)
                toolbarTitle.text = str
            }
            if (typedArray.hasValue(R.styleable.ToolBar_android_textSize)) {
                val textSize = typedArray.getDimension(R.styleable.ToolBar_android_textSize, 0f)
                val density = resources.displayMetrics.density
                toolbarTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize / density)
            }

            if (typedArray.hasValue(R.styleable.ToolBar_leftDrawable)) {
                val leftDrawable = typedArray.getDrawable(R.styleable.ToolBar_leftDrawable)
                toolbarLeftButton.setImageDrawable(leftDrawable)
                toolbarLeftButton.visible()
            } else {
                toolbarLeftButton.gone()
            }

            if (typedArray.hasValue(R.styleable.ToolBar_rightText)) {
                val str = typedArray.getString(R.styleable.ToolBar_rightText)
                txtRight.text = str
                txtRight.visible()
            } else {
                txtRight.gone()
            }

        } finally {
            typedArray.recycle()
        }
    }

    fun setToolbarTitle(toolbarTitle: CharSequence) {
        this.toolbarTitle.text = toolbarTitle
    }

    fun setBackButton(isBackButtonEnable: Boolean) {
        toolbarLeftButton.setImageResource(if (isBackButtonEnable) R.drawable.ic_back_arrow else R.drawable.ic_launcher)
    }

    fun setBackButtonListener(listener: View.OnClickListener?) {
        toolbarLeftButton.setOnClickListener(listener)
    }

    fun showRightText(isShow:Boolean){
        if(isShow) txtRight.visible() else txtRight.gone()
    }

    fun setRightText(txtRight: CharSequence) {
        this.txtRight.text = txtRight
    }

    fun getRightText():String {
        return txtRight.text.toString()
    }

    fun setRightButtonListener(listener: View.OnClickListener?) {
        txtRight.setOnClickListener(listener)
    }
}
