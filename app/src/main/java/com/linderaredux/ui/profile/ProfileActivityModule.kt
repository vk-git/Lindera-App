package com.linderaredux.ui.profile

import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ProfileActivityModule {

    @Provides
    fun provideProfileViewModel(linderaService: LinderaService, session: Session): ProfileViewModel {
        return ProfileViewModel(linderaService, session)
    }
}