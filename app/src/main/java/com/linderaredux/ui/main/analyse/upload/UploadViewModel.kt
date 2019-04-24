package com.linderaredux.ui.main.analyse.upload

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class UploadViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<UploadNavigator>(linderaService, session, dataManager) {

}