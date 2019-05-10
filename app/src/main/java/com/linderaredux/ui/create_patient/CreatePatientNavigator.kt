package com.linderaredux.ui.create_patient

import com.linderaredux.api.response.patient.Patient
import com.linderaredux.base.BaseNavigator


interface CreatePatientNavigator : BaseNavigator {
    fun onSaveHandle()
    fun onSuccessfullyCreated(patient: Patient)
}