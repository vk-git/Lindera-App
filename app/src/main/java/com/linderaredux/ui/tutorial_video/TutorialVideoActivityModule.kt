package com.linderaredux.ui.tutorial_video

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class TutorialVideoActivityModule {

    @Provides
    fun provideTutorialVideoViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): TutorialVideoViewModel {
        return TutorialVideoViewModel(linderaService, session,dataManager)
    }
}