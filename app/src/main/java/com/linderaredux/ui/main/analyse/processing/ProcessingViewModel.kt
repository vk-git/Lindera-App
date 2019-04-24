package com.linderaredux.ui.main.analyse.processing

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ProcessingViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<ProcessingNavigator>(linderaService, session, dataManager) {

}