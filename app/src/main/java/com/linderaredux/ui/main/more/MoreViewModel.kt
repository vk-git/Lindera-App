package com.linderaredux.ui.main.more

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.utils.Session


class MoreViewModel(linderaService: LinderaService, session: Session) : BaseViewModel<MoreNavigator>(linderaService, session) {
    fun onProfileClick(){
        getNavigator()?.onProfileScreen()
    }
    fun onFacilityClick(){
        getNavigator()?.onFacilityScreen()
    }
}