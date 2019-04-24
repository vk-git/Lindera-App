package com.linderaredux.ui.change_password

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ChangePasswordActivityModule {

    @Provides
    fun provideChangePasswordViewModel(linderaService: LinderaService, session: Session, dataManager: DataManager): ChangePasswordViewModel {
        return ChangePasswordViewModel(linderaService, session,dataManager)
    }
}