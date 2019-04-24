package com.linderaredux.ui.landing

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class LandingViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<LandingNavigator>(linderaService, session, dataManager) {

    fun onLoginButtonClick(){
        getNavigator()!!.onLoginScreen()
    }

    fun onRegisterButtonClick(){
        getNavigator()!!.onRegisterScreen()
    }
}