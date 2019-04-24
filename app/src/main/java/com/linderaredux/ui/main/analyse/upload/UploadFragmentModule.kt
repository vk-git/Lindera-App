package com.linderaredux.ui.main.analyse.upload

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
class UploadFragmentModule {

    @Provides
    fun uploadViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): UploadViewModel {
        return UploadViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun provideUploadViewModel(uploadViewModel: UploadViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(uploadViewModel)
    }

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}