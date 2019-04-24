package com.linderaredux.ui.change_password

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ChangePasswordViewModel(linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<ChangePasswordNavigator>(linderaService, session, dataManager) {

}