package com.linderaredux.ui.main.patient

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PatientFragmentProvider {

    @ContributesAndroidInjector(modules = [PatientFragmentModule::class])
    internal abstract fun providePatientFragmentFactory(): PatientFragment
}