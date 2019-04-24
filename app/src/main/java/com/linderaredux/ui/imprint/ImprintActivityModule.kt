package com.linderaredux.ui.imprint

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ImprintActivityModule {

    @Provides
    fun provideImprintViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): ImprintViewModel {
        return ImprintViewModel(linderaService, session,dataManager)
    }
}