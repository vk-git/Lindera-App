package com.linderaredux.ui.main.more

import androidx.lifecycle.ViewModelProvider
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class MoreFragmentModule {

    @Provides
    fun moreViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): MoreViewModel {
        return MoreViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun provideMoreViewModel(moreViewModel: MoreViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(moreViewModel)
    }
}