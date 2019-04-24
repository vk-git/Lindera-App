package com.linderaredux.ui.contact

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ContactActivityModule {

    @Provides
    fun provideContactViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): ContactViewModel {
        return ContactViewModel(linderaService, session,dataManager)
    }
}