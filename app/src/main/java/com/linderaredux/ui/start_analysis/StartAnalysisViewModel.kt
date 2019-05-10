package com.linderaredux.ui.start_analysis

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class StartAnalysisViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<StartAnalysisNavigator>(application,linderaService, session, dataManager) {

}