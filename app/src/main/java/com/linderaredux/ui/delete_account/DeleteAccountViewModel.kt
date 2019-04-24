package com.linderaredux.ui.delete_account

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class DeleteAccountViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<DeleteAccountNavigator>(linderaService, session, dataManager) {

}