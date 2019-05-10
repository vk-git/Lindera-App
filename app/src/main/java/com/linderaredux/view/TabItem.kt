package com.linderaredux.view

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.linderaredux.R
import com.linderaredux.extensions.gone
import com.linderaredux.extensions.visible

class TabItem(context: Context) : LinearLayout(context) {

    private lateinit var tabIcon: ImageView
    private lateinit var badge: TextView
    private lateinit var badgeCotainer: LinearLayout

    init {
        init(context)
    }

    private fun init(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.tab_item, this)

        tabIcon = findViewById(R.id.tab_icon)
        badge = findViewById(R.id.badge)
        badgeCotainer = findViewById(R.id.badgeCotainer)
    }

    fun setTabIcon(resId: Int) {
        tabIcon.setImageResource(resId)
    }

    fun setSelectedTab(color: Int) {
        tabIcon.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP)
    }

    fun setBadgeCount(count: Int) {
        if (count > 0) {
            badgeCotainer.visible()
            badge.text = "$count"
        } else {
            badgeCotainer.gone()
        }
    }
}
