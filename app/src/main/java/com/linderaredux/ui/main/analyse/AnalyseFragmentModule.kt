package com.linderaredux.ui.main.analyse

import androidx.lifecycle.ViewModelProvider
import com.linderaredux.adapter.AnalysisAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class AnalyseFragmentModule {

    @Provides
    fun analyseViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): AnalyseViewModel {
        return AnalyseViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun provideAnalyseViewModel(analyseViewModel: AnalyseViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(analyseViewModel)
    }

    @Provides
    fun provideAnalysisAdapter(analyseFragment: AnalyseFragment):AnalysisAdapter{
        return AnalysisAdapter(analyseFragment.childFragmentManager,3)
    }
}