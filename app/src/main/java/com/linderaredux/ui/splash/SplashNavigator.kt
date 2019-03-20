package com.linderaredux.ui.splash

import com.linderaredux.base.BaseNavigator


interface SplashNavigator : BaseNavigator {

    fun handleError(error: String)
    fun onLandingScreen()
}