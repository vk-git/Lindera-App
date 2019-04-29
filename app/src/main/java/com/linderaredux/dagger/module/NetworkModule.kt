package com.linderaredux.dagger.module

import android.app.Application
import com.linderaredux.BuildConfig
import com.linderaredux.api.service.LinderaApi
import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.RetrofitFactory
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesLinderaService(session: Session, application: Application): LinderaService {
        return LinderaService(RetrofitFactory.getRetrofit(session, application, BuildConfig.SERVICE_ENDPOINT).create(LinderaApi::class.java))
    }
}