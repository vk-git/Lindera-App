package com.linderaredux.ui.facility

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class FacilityActivityModule {

    @Provides
    fun provideFacilityViewModel(linderaService: LinderaService, session: Session, dataManager: DataManager): FacilityViewModel {
        return FacilityViewModel(linderaService, session, dataManager)
    }
}