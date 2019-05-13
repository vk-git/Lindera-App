package com.linderaredux.ui.register

import com.linderaredux.api.response.AppUser
import com.linderaredux.base.BaseNavigator


interface RegisterNavigator : BaseNavigator {
    fun onLoginScreen()
    fun onCheckValidation()
    fun onRegisterSuccessful(appUser: AppUser)
}