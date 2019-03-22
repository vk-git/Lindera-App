package com.linderaredux.ui.login

import com.linderaredux.api.service.LinderaService
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun provideLoginViewModel(linderaService: LinderaService, session: Session): LoginViewModel {
        return LoginViewModel(linderaService, session)
    }
}