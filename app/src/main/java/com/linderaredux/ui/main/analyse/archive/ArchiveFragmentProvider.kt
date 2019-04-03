package com.linderaredux.ui.main.analyse.archive

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArchiveFragmentProvider {

    @ContributesAndroidInjector(modules = [ArchiveFragmentModule::class])
    internal abstract fun provideArchiveFragmentFactory(): ArchiveFragment
}