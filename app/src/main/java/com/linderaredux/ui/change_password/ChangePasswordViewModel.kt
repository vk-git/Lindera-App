package com.linderaredux.ui.change_password

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ChangePasswordViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<ChangePasswordNavigator>(application,linderaService, session, dataManager) {

}