package com.linderaredux.ui.register

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class RegisterViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<RegisterNavigator>(application, linderaService, session, dataManager) {

    fun onLoginButtonClick(){
        getNavigator()!!.onLoginScreen()
    }
}