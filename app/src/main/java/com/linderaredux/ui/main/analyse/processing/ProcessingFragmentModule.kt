package com.linderaredux.ui.main.analyse.processing

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
class ProcessingFragmentModule {

    @Provides
    fun homeViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): ProcessingViewModel {
        return ProcessingViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun provideProcessingViewModel(processingViewModel: ProcessingViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(processingViewModel)
    }

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}