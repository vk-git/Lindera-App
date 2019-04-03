package com.linderaredux.ui.main.analyse.processing

import androidx.lifecycle.ViewModelProvider
import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ProcessingFragmentModule {

    @Provides
    fun homeViewModel(linderaService: LinderaService,session: Session): ProcessingViewModel {
        return ProcessingViewModel(linderaService,session)
    }

    @Provides
    fun provideProcessingViewModel(processingViewModel: ProcessingViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(processingViewModel)
    }
}