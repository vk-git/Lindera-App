package com.linderaredux.dagger

import com.linderaredux.ui.confirm_account.ConfirmAccountActivity
import com.linderaredux.ui.confirm_account.ConfirmAccountActivityModule
import com.linderaredux.ui.contact.ContactActivity
import com.linderaredux.ui.contact.ContactActivityModule
import com.linderaredux.ui.landing.LandingActivity
import com.linderaredux.ui.landing.LandingActivityModule
import com.linderaredux.ui.login.LoginActivity
import com.linderaredux.ui.login.LoginActivityModule
import com.linderaredux.ui.register.RegisterActivity
import com.linderaredux.ui.register.RegisterActivityModule
import com.linderaredux.ui.splash.SplashActivity
import com.linderaredux.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LandingActivityModule::class])
    internal abstract fun bindLandingActivity(): LandingActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [RegisterActivityModule::class])
    internal abstract fun bindRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector(modules = [ConfirmAccountActivityModule::class])
    internal abstract fun bindConfirmAccountActivity(): ConfirmAccountActivity

    @ContributesAndroidInjector(modules = [ContactActivityModule::class])
    internal abstract fun bindContactActivity(): ContactActivity
}