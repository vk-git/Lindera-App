package com.linderaredux.ui.main.patient

import com.linderaredux.adapter.patient.PatientAdapter
import dagger.Module
import dagger.Provides

@Module
class PatientFragmentModule {

    @Provides
    fun providePatientAdapter(): PatientAdapter {
        return PatientAdapter()
    }
}