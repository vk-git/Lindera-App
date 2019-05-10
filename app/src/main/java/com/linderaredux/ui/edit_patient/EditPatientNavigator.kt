package com.linderaredux.ui.edit_patient

import com.linderaredux.base.BaseNavigator


interface EditPatientNavigator : BaseNavigator {
    fun onDeletePatient()
    fun onStartAnalysis()
}