package com.linderaredux.ui.main.analyse

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class AnalyseViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<AnalyseNavigator>(linderaService, session, dataManager) {

}