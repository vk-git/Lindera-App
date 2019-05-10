package com.linderaredux.ui.main.analyse

import com.linderaredux.adapter.AnalysisAdapter
import dagger.Module
import dagger.Provides

@Module
class AnalyseFragmentModule {

    @Provides
    fun provideAnalysisAdapter(analyseFragment: AnalyseFragment): AnalysisAdapter {
        return AnalysisAdapter(analyseFragment.childFragmentManager, 3)
    }
}