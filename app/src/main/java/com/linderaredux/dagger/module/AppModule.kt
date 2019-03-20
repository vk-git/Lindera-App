package com.linderaredux.dagger.module

import android.app.Application
import android.content.Context
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSession(context: Context): Session {
        return Session(context)
    }
}