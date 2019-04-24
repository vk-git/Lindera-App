package com.linderaredux.ui.start_analysis

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class StartAnalysisViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<StartAnalysisNavigator>(linderaService, session, dataManager) {

}