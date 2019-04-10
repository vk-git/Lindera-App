package com.linderaredux.ui.main.more

import com.linderaredux.base.BaseNavigator

interface MoreNavigator : BaseNavigator {
    fun onProfileScreen()
    fun onFacilityScreen()
    fun onLogout()
}