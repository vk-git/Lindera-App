package com.linderaredux.ui.delete_account

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class DeleteAccountActivityModule {

    @Provides
    fun provideDeleteAccountViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): DeleteAccountViewModel {
        return DeleteAccountViewModel(linderaService, session,dataManager)
    }
}