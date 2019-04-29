package com.linderaredux.db

import com.linderaredux.api.response.patient.Patient

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable

class DataManager(internal var appDbHelper: AppDbHelper) {

    val allPatients: Observable<List<Patient>>
        get() = appDbHelper.allPatients

    fun savePatientList(patientList: List<Patient>): Observable<Boolean> {
        return appDbHelper.savePatientList(patientList)
    }
}
