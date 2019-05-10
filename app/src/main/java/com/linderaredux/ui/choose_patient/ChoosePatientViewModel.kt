package com.linderaredux.ui.choose_patient

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ChoosePatientViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<ChoosePatientNavigator>(application,linderaService, session, dataManager) {

}