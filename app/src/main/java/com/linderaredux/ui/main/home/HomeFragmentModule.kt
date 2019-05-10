package com.linderaredux.ui.main.home

import android.content.Context
import com.linderaredux.adapter.AnalysisBoxAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideAnalysisBoxAdapter(context: Context): AnalysisBoxAdapter {
        return AnalysisBoxAdapter(context)
    }
}