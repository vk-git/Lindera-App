package com.linderaredux.ui.main.analyse

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AnalyseFragmentProvider {

    @ContributesAndroidInjector(modules = [AnalyseFragmentModule::class])
    internal abstract fun provideMoreFragmentFactory(): AnalyseFragment
}