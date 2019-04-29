package com.linderaredux.db;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

public class DataManager {

    AppDbHelper appDbHelper;

    public DataManager(AppDbHelper appDbHelper) {
        this.appDbHelper = appDbHelper;
    }

    public Observable<List<Patient>> getAllPatients() {
        return appDbHelper.getAllPatients();
    }

    public Observable<Boolean> savePatientList(List<Patient> patientList) {
        return appDbHelper.savePatientList(patientList);
    }
}
