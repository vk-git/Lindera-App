package com.linderaredux.ui.register

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.utils.Session


class RegisterViewModel(linderaService: LinderaService, session: Session) : BaseViewModel<RegisterNavigator>(linderaService, session) {

    fun onLoginButtonClick(){
        getNavigator()!!.onLoginScreen()
    }
}