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
    fun providePatientAdapter(): PatientAdapter {
        return PatientAdapter()
    }
}