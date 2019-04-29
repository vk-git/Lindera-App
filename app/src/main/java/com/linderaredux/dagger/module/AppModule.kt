package com.linderaredux.dagger.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.linderaredux.db.*
import com.linderaredux.utils.Constant
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

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Constant.DB_NAME).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideDataManager(appDbHelper: AppDbHelper): DataManager {
        return DataManager(appDbHelper)
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDatabase: AppDatabase): AppDbHelper {
        return AppDbHelper(appDatabase)
    }
}