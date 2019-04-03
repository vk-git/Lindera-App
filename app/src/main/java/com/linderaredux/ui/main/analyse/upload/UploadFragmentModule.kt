package com.linderaredux.ui.main.analyse.upload

import androidx.lifecycle.ViewModelProvider
import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class UploadFragmentModule {

    @Provides
    fun uploadViewModel(linderaService: LinderaService,session: Session): UploadViewModel {
        return UploadViewModel(linderaService,session)
    }

    @Provides
    fun provideUploadViewModel(uploadViewModel: UploadViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(uploadViewModel)
    }
}