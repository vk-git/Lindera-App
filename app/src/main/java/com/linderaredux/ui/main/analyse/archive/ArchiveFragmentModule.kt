package com.linderaredux.ui.main.analyse.archive

import android.content.Context
import com.linderaredux.adapter.AnalysisBoxAdapter
import dagger.Module
import dagger.Provides

@Module
class ArchiveFragmentModule {

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}