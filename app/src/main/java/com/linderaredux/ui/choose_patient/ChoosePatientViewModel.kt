package com.linderaredux.ui.choose_patient

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ChoosePatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<ChoosePatientNavigator>(linderaService, session, dataManager) {

}