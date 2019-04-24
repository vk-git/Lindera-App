package com.linderaredux.ui.facility

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class FacilityViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<FacilityNavigator>(linderaService, session, dataManager) {

}