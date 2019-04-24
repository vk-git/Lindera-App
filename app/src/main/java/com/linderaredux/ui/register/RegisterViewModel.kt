package com.linderaredux.ui.register

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class RegisterViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<RegisterNavigator>(linderaService, session, dataManager) {

    fun onLoginButtonClick(){
        getNavigator()!!.onLoginScreen()
    }
}