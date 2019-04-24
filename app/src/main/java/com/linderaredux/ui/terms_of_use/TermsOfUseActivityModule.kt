package com.linderaredux.ui.terms_of_use

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class TermsOfUseActivityModule {

    @Provides
    fun provideTermsOfUseViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): TermsOfUseViewModel {
        return TermsOfUseViewModel(linderaService, session,dataManager)
    }
}