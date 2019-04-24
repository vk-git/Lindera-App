package com.linderaredux.ui.main

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): MainViewModel {
        return MainViewModel(linderaService, session,dataManager)
    }
}