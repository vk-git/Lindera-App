package com.linderaredux.ui.main.analyse.processing

import android.content.Context
import com.linderaredux.adapter.AnalysisBoxAdapter
import dagger.Module
import dagger.Provides

@Module
class ProcessingFragmentModule {

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}