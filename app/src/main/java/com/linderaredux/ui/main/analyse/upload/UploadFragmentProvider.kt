package com.linderaredux.ui.main.analyse.upload

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UploadFragmentProvider {

    @ContributesAndroidInjector(modules = [UploadFragmentModule::class])
    internal abstract fun provideUploadFragmentFactory(): UploadFragment
}