package com.linderaredux.ui.splash

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    fun provideSplashViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): SplashViewModel {
        return SplashViewModel(linderaService, session,dataManager)
    }
}