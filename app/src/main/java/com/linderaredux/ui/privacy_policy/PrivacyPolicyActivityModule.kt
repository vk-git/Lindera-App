package com.linderaredux.ui.privacy_policy

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class PrivacyPolicyActivityModule {

    @Provides
    fun providePrivacyPolicyViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): PrivacyPolicyViewModel {
        return PrivacyPolicyViewModel(linderaService, session,dataManager)
    }
}