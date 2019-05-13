package com.linderaredux.api.service

import com.google.gson.JsonObject
import com.linderaredux.api.ApiResponseCallbackWrapper
import com.linderaredux.api.ResponseListener
import com.linderaredux.api.response.AppUser
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.response.UserHome
import com.linderaredux.api.response.patient.Patient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class LinderaService(private val linderaApi: LinderaApi) {

    fun userRegister(registerReq: JsonObject, listener: ResponseListener<Response<BaseResponse<AppUser>>, String>): Disposable {
        return linderaApi.userRegister(registerReq)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponseCallbackWrapper<Response<BaseResponse<AppUser>>>() {

                    override fun onSuccess(response: Response<BaseResponse<AppUser>>) {
                        listener.onSuccess(response)
                    }

                    override fun onInternetConnectionError() {
                        listener.onInternetConnectionError()
                    }

                    override fun onFailure(error: String) {
                        listener.onFailure(error)
                    }
                })
    }

    fun userLogin(loginReq: JsonObject, listener: ResponseListener<Response<BaseResponse<AppUser>>, String>): Disposable {
        return linderaApi.userLogin(loginReq)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponseCallbackWrapper<Response<BaseResponse<AppUser>>>() {

                    override fun onSuccess(response: Response<BaseResponse<AppUser>>) {
                        listener.onSuccess(response)
                    }

                    override fun onInternetConnectionError() {
                        listener.onInternetConnectionError()
                    }

                    override fun onFailure(error: String) {
                        listener.onFailure(error)
                    }
                })
    }

    fun userHome(homeId: String,listener: ResponseListener<Response<BaseResponse<UserHome>>, String>): Disposable {
        return linderaApi.userHome(homeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponseCallbackWrapper<Response<BaseResponse<UserHome>>>() {

                    override fun onSuccess(response: Response<BaseResponse<UserHome>>) {
                        listener.onSuccess(response)
                    }

                    override fun onInternetConnectionError() {
                        listener.onInternetConnectionError()
                    }

                    override fun onFailure(error: String) {
                        listener.onFailure(error)
                    }
                })
    }

    fun userPatients(listener: ResponseListener<Response<BaseResponse<List<Patient>>>, String>): Disposable {
        return linderaApi.userPatients()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponseCallbackWrapper<Response<BaseResponse<List<Patient>>>>() {

                    override fun onSuccess(response: Response<BaseResponse<List<Patient>>>) {
                        listener.onSuccess(response)
                    }

                    override fun onInternetConnectionError() {
                        listener.onInternetConnectionError()
                    }

                    override fun onFailure(error: String) {
                        listener.onFailure(error)
                    }
                })
    }

    fun userCreatePatient(patientReq: JsonObject, listener: ResponseListener<Response<BaseResponse<Patient>>, String>): Disposable {
        return linderaApi.userCreatePatient(patientReq)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponseCallbackWrapper<Response<BaseResponse<Patient>>>() {

                    override fun onSuccess(response: Response<BaseResponse<Patient>>) {
                        listener.onSuccess(response)
                    }

                    override fun onInternetConnectionError() {
                        listener.onInternetConnectionError()
                    }

                    override fun onFailure(error: String) {
                        listener.onFailure(error)
                    }
                })
    }

    fun deletePatient(patientId: String,listener: ResponseListener<Response<BaseResponse<Patient>>, String>): Disposable {
        return linderaApi.deletePatient(patientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiResponseCallbackWrapper<Response<BaseResponse<Patient>>>() {

                    override fun onSuccess(response: Response<BaseResponse<Patient>>) {
                        listener.onSuccess(response)
                    }

                    override fun onInternetConnectionError() {
                        listener.onInternetConnectionError()
                    }

                    override fun onFailure(error: String) {
                        listener.onFailure(error)
                    }
                })
    }
}