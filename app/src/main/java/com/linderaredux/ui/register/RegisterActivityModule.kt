package com.linderaredux.ui.register

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class RegisterActivityModule {

    @Provides
    fun provideRegisterViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): RegisterViewModel {
        return RegisterViewModel(linderaService, session,dataManager)
    }
}