package com.linderaredux.ui.choose_home

import com.linderaredux.adapter.HomesAdapter
import com.linderaredux.adapter.patient.PatientAdapter
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import dagger.Module
import dagger.Provides

@Module
class ChooseHomeActivityModule {

    @Provides
    fun provideHomesAdapter(): HomesAdapter {
        return HomesAdapter()
    }
}