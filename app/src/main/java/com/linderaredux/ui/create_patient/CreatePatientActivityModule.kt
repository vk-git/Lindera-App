package com.linderaredux.ui.create_patient

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class CreatePatientActivityModule {

    @Provides
    fun provideCreatePatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): CreatePatientViewModel {
        return CreatePatientViewModel(linderaService, session,dataManager)
    }
}