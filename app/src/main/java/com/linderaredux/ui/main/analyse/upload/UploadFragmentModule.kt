package com.linderaredux.ui.main.analyse.upload

import android.content.Context
import com.linderaredux.adapter.AnalysisBoxAdapter
import dagger.Module
import dagger.Provides

@Module
class UploadFragmentModule {

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}