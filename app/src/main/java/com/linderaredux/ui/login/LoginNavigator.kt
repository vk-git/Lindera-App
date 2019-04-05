package com.linderaredux.ui.login

import com.linderaredux.base.BaseNavigator


interface LoginNavigator : BaseNavigator {
    fun onRegisterScreen()
    fun onLoginHandle()
    fun onMainScreen()
}