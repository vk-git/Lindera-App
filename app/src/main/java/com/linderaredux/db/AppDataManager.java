package com.linderaredux.db;

import android.content.Context;

import com.linderaredux.api.response.patient.Patient;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;

    private final DbHelper mDbHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;
    }

    @Override
    public Observable<List<Patient>> getAllPatients() {
        return mDbHelper.getAllPatients();
    }

    @Override
    public Observable<Boolean> savePatientList(List<Patient> patientList) {
        return mDbHelper.savePatientList(patientList);
    }
}
