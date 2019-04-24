package com.linderaredux.ui.edit_patient

import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class EditPatientActivityModule {

    @Provides
    fun provideEditPatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager): EditPatientViewModel {
        return EditPatientViewModel(linderaService, session,dataManager)
    }
}