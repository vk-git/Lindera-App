package com.linderaredux.ui.splash

import android.os.Handler
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.utils.Session


class SplashViewModel(linderaService: LinderaService, session: Session) : BaseViewModel<SplashNavigator>(linderaService, session) {

    fun onTimeHandler(){
        Handler().postDelayed({ getNavigator()!!.onLandingScreen() },3000)
    }
}