package com.linderaredux.ui.main.more

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoreFragmentProvider {

    @ContributesAndroidInjector(modules = [MoreFragmentModule::class])
    internal abstract fun provideMoreFragmentFactory(): MoreFragment
}