package com.linderaredux.ui.landing

import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class LandingActivityModule {

    @Provides
    fun provideLandingViewModel(linderaService: LinderaService, session: Session): LandingViewModel {
        return LandingViewModel(linderaService, session)
    }
}