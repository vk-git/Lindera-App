package com.linderaredux.db.dao;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PatientDao {

    @Query("SELECT id FROM patient WHERE id = :id LIMIT 1")
    String getItemId(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Patient patient);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(Patient patient);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Patient> patientList);

    @Query("SELECT * FROM patient")
    List<Patient> loadAll();
}
