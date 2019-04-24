package com.linderaredux.dagger.module

import android.app.Application
import android.content.Context
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import androidx.room.Room
import com.linderaredux.db.*
import com.linderaredux.db.DatabaseInfo
import com.linderaredux.utils.Constant


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
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return Constant.DB_NAME
    }
}