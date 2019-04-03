package com.linderaredux.ui.main.analyse.processing

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProcessingFragmentProvider {

    @ContributesAndroidInjector(modules = [ProcessingFragmentModule::class])
    internal abstract fun provideProcessingFragmentFactory(): ProcessingFragment
}