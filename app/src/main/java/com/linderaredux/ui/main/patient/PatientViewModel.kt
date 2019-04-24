package com.linderaredux.ui.main.patient

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class PatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<PatientNavigator>(linderaService, session, dataManager) {

}