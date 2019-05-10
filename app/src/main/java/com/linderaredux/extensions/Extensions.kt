package com.linderaredux.extensions

import androidx.viewpager.widget.ViewPager

val ViewPager.lastItem: Int?
    get() = adapter?.count?.minus(1)