package com.linderaredux.ui.register

import android.app.Application
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.linderaredux.api.ResponseListener
import com.linderaredux.api.response.AppUser
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.SharedPreferenceHelper
import retrofit2.Response


class RegisterViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<RegisterNavigator>(application, linderaService, session, dataManager) {

    fun onLoginButtonClick() {
        getNavigator()!!.onLoginScreen()
    }

    fun onRegisterButtonClick() {
        getNavigator()!!.onCheckValidation()
    }

    fun register(registerReq: JsonObject) {
        getCompositeDisposable()?.add(getLinderaService().userRegister(registerReq, object : ResponseListener<Response<BaseResponse<AppUser>>, String> {
            override fun onSuccess(response: Response<BaseResponse<AppUser>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        getSession().setAppUser(it.data)
                        getSession().setAppUserToken(it.token)
                        getNavigator()?.onRegisterSuccessful(it.data)
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
}