package com.linderaredux.ui.choose_patient

import com.linderaredux.adapter.patient.PatientAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ChoosePatientActivityModule {

    @Provides
    fun provideChoosePatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): ChoosePatientViewModel {
        return ChoosePatientViewModel(linderaService, session,dataManager)
    }

    @Provides
    fun providePatientAdapter(): PatientAdapter {
        return PatientAdapter()
    }
}