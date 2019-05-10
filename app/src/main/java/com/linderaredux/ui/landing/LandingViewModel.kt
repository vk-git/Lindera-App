package com.linderaredux.ui.landing

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class LandingViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<LandingNavigator>(application, linderaService, session, dataManager) {

    fun onLoginButtonClick() {
        getNavigator()!!.onLoginScreen()
    }

    fun onRegisterButtonClick() {
        getNavigator()!!.onRegisterScreen()
    }
}