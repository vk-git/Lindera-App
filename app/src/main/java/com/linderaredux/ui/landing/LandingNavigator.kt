package com.linderaredux.ui.landing

import com.linderaredux.base.BaseNavigator


interface LandingNavigator : BaseNavigator {

    fun handleError(error: String)
    fun onLoginScreen()
    fun onRegisterScreen()
}