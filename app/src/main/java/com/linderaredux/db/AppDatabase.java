package com.linderaredux.db;

import com.linderaredux.api.response.patient.Patient;
import com.linderaredux.db.dao.PatientDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Patient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PatientDao patientDao();

}
