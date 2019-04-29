package com.linderaredux.db;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

public class AppDbHelper {

    private final AppDatabase mAppDatabase;

    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    public Observable<List<Patient>> getAllPatients() {
        return Observable.fromCallable(() -> mAppDatabase.patientDao().loadAll());
    }

    public Observable<Boolean> savePatientList(List<Patient> patientList) {
        return Observable.fromCallable(() -> {
            mAppDatabase.patientDao().insertAll(patientList);
            return true;
        });
    }
}
