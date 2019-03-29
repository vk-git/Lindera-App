package com.linderaredux.ui.main

import com.linderaredux.base.BaseNavigator


interface MainNavigator : BaseNavigator {
    fun handleError(error: String)
}