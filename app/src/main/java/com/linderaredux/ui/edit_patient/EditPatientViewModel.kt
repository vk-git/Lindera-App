package com.linderaredux.ui.edit_patient

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class EditPatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<EditPatientNavigator>(linderaService, session, dataManager) {

}