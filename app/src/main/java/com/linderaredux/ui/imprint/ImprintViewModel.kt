package com.linderaredux.ui.imprint

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ImprintViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<ImprintNavigator>(linderaService, session, dataManager) {

}