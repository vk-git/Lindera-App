package com.linderaredux.dagger

import android.app.Application
import com.linderaredux.App
import com.linderaredux.dagger.module.AppModule
import com.linderaredux.dagger.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, NetworkModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}