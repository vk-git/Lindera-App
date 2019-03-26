package com.linderaredux.view

import androidx.viewpager.widget.ViewPager

val ViewPager.lastItem: Int?
    get() = adapter?.count?.minus(1)