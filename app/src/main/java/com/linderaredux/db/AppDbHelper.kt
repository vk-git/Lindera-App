package com.linderaredux.db

import com.linderaredux.api.response.patient.Patient
import io.reactivex.Observable

class AppDbHelper(private val mAppDatabase: AppDatabase) {

    val allPatients: Observable<List<Patient>>
        get() = Observable.fromCallable { mAppDatabase.patientDao().loadAll() }

    fun savePatientList(patientList: List<Patient>): Observable<Boolean> {
        return Observable.fromCallable {
            patientList.forEach {
                insertOrUpdate(it)
            }
            true
        }
    }

    private fun insertOrUpdate(item: Patient) {
        mAppDatabase.runInTransaction {
            val id = mAppDatabase.patientDao().getItemId(item.id)
            if (id == null)
                mAppDatabase.patientDao().insert(item)
            else
                mAppDatabase.patientDao().update(item)
        }
    }
}