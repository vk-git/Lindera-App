package com.linderaredux.ui.edit_patient

import android.app.Application
import com.google.gson.reflect.TypeToken
import com.linderaredux.api.ResponseListener
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.SharedPreferenceHelper
import retrofit2.Response


class EditPatientViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<EditPatientNavigator>(application, linderaService, session, dataManager) {

    fun onDeleteButtonClick() {
        getNavigator()?.onDeletePatient()
    }

    fun onStartAnalysisButtonClick() {
        getNavigator()?.onStartAnalysis()
    }

    fun deletePatient(patientId: String) {
        getCompositeDisposable()?.add(getLinderaService().deletePatient(patientId, object : ResponseListener<Response<BaseResponse<Patient>>, String> {
            override fun onSuccess(response: Response<BaseResponse<Patient>>) {
                if (response.isSuccessful) {
                    getDataManager().deletePatientById(patientId)
                } else {
                    try {
                        val errorResponse = SharedPreferenceHelper.getObjectFromString(response.errorBody()!!.string(), object : TypeToken<BaseResponse<String>>() {})
                        getNavigator()?.handleError(errorResponse.data)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onInternetConnectionError() {
                getNavigator()?.onInternetConnectionError()
            }

            override fun onFailure(error: String) {
                getNavigator()?.handleError(error)
            }
        }))
    }

}