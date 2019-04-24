package com.linderaredux.ui.splash

import android.os.Handler
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class SplashViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<SplashNavigator>(linderaService, session, dataManager) {

    fun onTimeHandler(){
        Handler().postDelayed({
            if(getSession().getAppUserToken().isEmpty()) {
                getNavigator()!!.onLandingScreen()
            }else{
                getNavigator()!!.onMainScreen()
            }
        },3000)
    }
}