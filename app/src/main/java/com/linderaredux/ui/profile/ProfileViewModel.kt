package com.linderaredux.ui.profile

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ProfileViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<ProfileNavigator>(linderaService, session, dataManager) {

}