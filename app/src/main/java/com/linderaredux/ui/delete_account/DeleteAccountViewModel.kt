package com.linderaredux.ui.delete_account

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class DeleteAccountViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<DeleteAccountNavigator>(application, linderaService, session, dataManager) {

}