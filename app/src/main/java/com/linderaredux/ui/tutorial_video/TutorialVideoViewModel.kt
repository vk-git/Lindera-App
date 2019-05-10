package com.linderaredux.ui.tutorial_video

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class TutorialVideoViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<TutorialVideoNavigator>(application, linderaService, session, dataManager) {

}