package com.linderaredux.ui.main.more

import com.linderaredux.base.BaseNavigator

interface MoreNavigator : BaseNavigator {
    fun onProfileScreen()
    fun onFacilityScreen()
    fun onLogout()
    fun onHowRecordAnalysisScreen()
    fun onChangePasswordScreen()
    fun onFeedBackScreen()
    fun onContactScreen()
    fun onFAQScreen()
    fun onTeamsOfUseScreen()
    fun onPrivacyPolicyScreen()
    fun onImprintScreen()
    fun onDeleteAccountScreen()
}