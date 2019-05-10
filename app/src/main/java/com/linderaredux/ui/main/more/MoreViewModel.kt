package com.linderaredux.ui.main.more

import android.app.Application
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class MoreViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<MoreNavigator>(application, linderaService, session, dataManager) {

    fun onHowRecordAnalysisClick() {
        getNavigator()?.onHowRecordAnalysisScreen()
    }

    fun onChangePasswordClick() {
        getNavigator()?.onChangePasswordScreen()
    }

    fun onDeleteAccountClick() {
        getNavigator()?.onDeleteAccountScreen()
    }

    fun onFeedBackClick() {
        getNavigator()?.onFeedBackScreen()
    }

    fun onContactLinderaClick() {
        getNavigator()?.onContactScreen()
    }

    fun onFAQClick() {
        getNavigator()?.onFAQScreen()
    }

    fun onTeamsOfUseClick() {
        getNavigator()?.onTeamsOfUseScreen()
    }

    fun onPrivacyPolicyClick() {
        getNavigator()?.onPrivacyPolicyScreen()
    }

    fun onImprintClick() {
        getNavigator()?.onImprintScreen()
    }

    fun onProfileClick() {
        getNavigator()?.onProfileScreen()
    }

    fun onFacilityClick() {
        getNavigator()?.onFacilityScreen()
    }

    fun onLogoutClick() {
        getSession()?.logout()
        getNavigator()?.onLogout()
    }
}