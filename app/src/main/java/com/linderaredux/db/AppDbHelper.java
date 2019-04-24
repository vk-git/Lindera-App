package com.linderaredux.db;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<Patient>> getAllPatients() {
        return Observable.fromCallable(() -> mAppDatabase.patientDao().loadAll());
    }

    @Override
    public Observable<Boolean> savePatientList(List<Patient> patientList) {
        return Observable.fromCallable(() -> {
            mAppDatabase.patientDao().insertAll(patientList);
            return true;
        });
    }
}
