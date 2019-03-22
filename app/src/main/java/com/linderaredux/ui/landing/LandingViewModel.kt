package com.linderaredux.ui.landing

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.utils.Session


class LandingViewModel(linderaService: LinderaService, session: Session) : BaseViewModel<LandingNavigator>(linderaService, session) {

    fun onLoginButtonClick(){
        getNavigator()!!.onLoginScreen()
    }
}