package com.linderaredux.db.dao;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

public interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Patient patient);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Patient> patientList);

    @Query("SELECT * FROM patient")
    List<Patient> loadAll();
}
