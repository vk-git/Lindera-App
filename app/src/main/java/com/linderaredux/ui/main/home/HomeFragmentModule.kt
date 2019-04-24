package com.linderaredux.ui.main.home

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.linderaredux.adapter.AnalysisBoxAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun homeViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): HomeViewModel {
        return HomeViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(homeViewModel)
    }

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}