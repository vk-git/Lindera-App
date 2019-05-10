package com.linderaredux.ui.privacy_policy

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class PrivacyPolicyViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<PrivacyPolicyNavigator>(application, linderaService, session, dataManager) {

}