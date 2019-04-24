package com.linderaredux.ui.main.home

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class HomeViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<HomeNavigator>(linderaService, session, dataManager) {

}