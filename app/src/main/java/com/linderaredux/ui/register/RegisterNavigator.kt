package com.linderaredux.ui.register

import com.linderaredux.base.BaseNavigator


interface RegisterNavigator : BaseNavigator {

    fun handleError(error: String)
    fun onLoginScreen()
}