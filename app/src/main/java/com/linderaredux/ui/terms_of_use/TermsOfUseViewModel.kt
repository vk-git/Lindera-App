package com.linderaredux.ui.terms_of_use

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class TermsOfUseViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<TermsOfUseNavigator>(application, linderaService, session, dataManager) {

}