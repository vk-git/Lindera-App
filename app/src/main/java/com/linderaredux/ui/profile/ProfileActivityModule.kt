package com.linderaredux.ui.profile

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ProfileActivityModule {

    @Provides
    fun provideProfileViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): ProfileViewModel {
        return ProfileViewModel(linderaService, session,dataManager)
    }
}