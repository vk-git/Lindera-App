package com.linderaredux.ui.confirm_account

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ConfirmAccountViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<ConfirmAccountNavigator>(application,linderaService, session, dataManager) {

}