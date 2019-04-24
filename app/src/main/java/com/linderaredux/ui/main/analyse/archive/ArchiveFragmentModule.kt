package com.linderaredux.ui.main.analyse.archive

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
class ArchiveFragmentModule {

    @Provides
    fun archiveViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): ArchiveViewModel {
        return ArchiveViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun provideArchiveViewModel(uploadViewModel: ArchiveViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(uploadViewModel)
    }

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}