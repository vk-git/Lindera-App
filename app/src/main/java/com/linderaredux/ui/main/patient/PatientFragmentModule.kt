package com.linderaredux.ui.main.patient

import androidx.lifecycle.ViewModelProvider
import com.linderaredux.adapter.patient.PatientAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class PatientFragmentModule {

    @Provides
    fun patientViewModel(linderaService: LinderaService,session: Session,dataManager: DataManager): PatientViewModel {
        return PatientViewModel(linderaService,session,dataManager)
    }

    @Provides
    fun providePatientViewModel(patientViewModel: PatientViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(patientViewModel)
    }

    @Provides
    fun providePatientAdapter(): PatientAdapter{
        return PatientAdapter()
    }
}