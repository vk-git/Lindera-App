package com.linderaredux.ui.main.more

import com.linderaredux.base.BaseNavigator

interface MoreNavigator : BaseNavigator {
    fun handleError(error: String)
}