package com.linderaredux.ui.start_analysis

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class StartAnalysisActivityModule {

    @Provides
    fun provideStartAnalysisViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): StartAnalysisViewModel {
        return StartAnalysisViewModel(linderaService, session,dataManager)
    }
}