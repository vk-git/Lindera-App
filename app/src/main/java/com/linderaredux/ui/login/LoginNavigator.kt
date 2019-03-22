package com.linderaredux.ui.login

import com.linderaredux.base.BaseNavigator


interface LoginNavigator : BaseNavigator {

    fun handleError(error: String)
}