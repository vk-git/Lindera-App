package com.linderaredux.ui.landing

import android.content.Context
import com.linderaredux.adapter.CustomPagerAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class LandingActivityModule {

    @Provides
    fun provideLandingViewModel(linderaService: LinderaService, session: Session): LandingViewModel {
        return LandingViewModel(linderaService, session)
    }

    @Provides
    fun provideCustomPagerAdapter(context: Context): CustomPagerAdapter{
        return CustomPagerAdapter(context)
    }
}