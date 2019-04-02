package com.linderaredux.ui.main.home

import androidx.lifecycle.ViewModelProvider
import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun homeViewModel(linderaService: LinderaService,session: Session): HomeViewModel {
        return HomeViewModel(linderaService,session)
    }

    @Provides
    fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(homeViewModel)
    }
}