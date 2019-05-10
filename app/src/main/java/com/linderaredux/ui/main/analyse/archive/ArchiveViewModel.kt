package com.linderaredux.ui.main.analyse.archive

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ArchiveViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<ArchiveNavigator>(application,linderaService, session, dataManager) {

}