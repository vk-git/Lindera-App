package com.linderaredux.ui.confirm_account

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ConfirmAccountActivityModule {

    @Provides
    fun provideConfirmAccountViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): ConfirmAccountViewModel {
        return ConfirmAccountViewModel(linderaService, session,dataManager)
    }
}