package com.linderaredux.ui.choose_home

import com.linderaredux.api.response.UserHome
import com.linderaredux.base.BaseNavigator

interface ChooseHomeNavigator : BaseNavigator {
    fun getUserHomeList(data: List<UserHome>)
}