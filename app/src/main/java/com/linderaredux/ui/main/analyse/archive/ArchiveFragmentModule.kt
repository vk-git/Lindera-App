package com.linderaredux.ui.main.analyse.archive

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.linderaredux.adapter.AnalysisBoxAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ArchiveFragmentModule {

    @Provides
    fun archiveViewModel(linderaService: LinderaService,session: Session): ArchiveViewModel {
        return ArchiveViewModel(linderaService,session)
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