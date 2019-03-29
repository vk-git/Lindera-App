package com.linderaredux.ui.main.home

import com.linderaredux.base.BaseNavigator

interface HomeNavigator : BaseNavigator {
    fun handleError(error: String)
}