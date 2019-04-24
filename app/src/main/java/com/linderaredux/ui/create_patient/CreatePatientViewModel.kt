package com.linderaredux.ui.create_patient

import com.google.gson.JsonObject
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


class CreatePatientViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<CreatePatientNavigator>(linderaService, session, dataManager) {

    fun onSaveButtonClick() {
        getNavigator()?.onSaveHandle()
    }

    fun userCreatePatient(patientReq: JsonObject){
        getCompositeDisposable()?.add(getLinderaService().userCreatePatient(patientReq, object : ResponseListener<Response<BaseResponse<Patient>>, String> {
            override fun onSuccess(response: Response<BaseResponse<Patient>>) {
                if (response.isSuccessful) {

                } else {
                    val errorResponse = SharedPreferenceHelper.getObjectFromString(response.errorBody()!!.string(), object : TypeToken<BaseResponse<String>>() {})
                    getNavigator()?.handleError(errorResponse.data)
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