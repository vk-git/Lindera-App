package com.linderaredux.db;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<List<Patient>> getAllPatients();

    Observable<Boolean> savePatientList(List<Patient> patientList);
}
