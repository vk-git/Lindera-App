package com.linderaredux.ui.main

import android.app.Application
import android.util.Log
import com.google.gson.reflect.TypeToken
import com.linderaredux.api.ResponseListener
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.response.UserHome
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.SharedPreferenceHelper
import com.linderaredux.utils.Sort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MainViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<MainNavigator>(application, linderaService, session, dataManager) {

    fun userHome() {
        val homeId = getSession().getAppUser()?.run { userHome.Id }
        getCompositeDisposable()?.add(getLinderaService().userHome(homeId, object : ResponseListener<Response<BaseResponse<UserHome>>, String> {
            override fun onSuccess(response: Response<BaseResponse<UserHome>>) {
                if (response.isSuccessful) {
                    response.body()?.run {
                        getSession().setAppUserHome(data)
                    }
                    getNavigator()?.onHomeDataUpdate()
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

    fun userPatients() {
        getCompositeDisposable()?.add(getLinderaService().userPatients(object : ResponseListener<Response<BaseResponse<List<Patient>>>, String> {
            override fun onSuccess(response: Response<BaseResponse<List<Patient>>>) {
                if (response.isSuccessful) {
                    response.body()?.run {
                        val list = data
                        Sort.onPatientList(list)
                        definePatientLists(list)
                    }
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

    fun definePatientLists(list: List<Patient>) {
        getCompositeDisposable()?.run {
            add(getDataManager().savePatientList(list)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if (it) {
                            Log.d("mytatg", "Successfully added")
                        }
                    })
        }

        val archiveList = ArrayList<Patient>()
        val progressList = ArrayList<Patient>()
        val uploadList = ArrayList<Patient>()
        val questionnaireUploadList = ArrayList<Patient>()
        val nonList = ArrayList<Patient>()
        Sort.onPatientList(list)
        if (list.isNotEmpty()) {
            list.forEach { patient ->
                if (patient.analyse!!.isEmpty()) {
                    nonList.add(patient)
                } else if (!patient.analyse[patient.analyse.size - 1].submittedByUser) {
                    progressList.add(patient)
                    if (patient.analyse.size > 1) {
                        if (patient.analyse[patient.analyse.size - 2].submittedByUser) {
                            archiveList.add(patient)
                        }
                    }
                } else {
                    archiveList.add(patient)
                }
            }
        }


        getSession().setArchiveList(archiveList)
        getSession().setProgressList(archiveList)
        getNavigator()?.onPatientDataUpdate()
    }
}