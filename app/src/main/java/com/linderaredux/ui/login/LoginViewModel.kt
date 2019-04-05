package com.linderaredux.ui.login

import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.linderaredux.api.ResponseListener
import com.linderaredux.api.response.AppUser
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.utils.Session
import com.linderaredux.utils.SharedPreferenceHelper
import retrofit2.Response


class LoginViewModel(linderaService: LinderaService, session: Session) : BaseViewModel<LoginNavigator>(linderaService, session) {

    fun onRegisterButtonClick() {
        getNavigator()!!.onRegisterScreen()
    }

    fun onLoginButtonClick() {
        getNavigator()?.onLoginHandle()
    }

    fun login(loginReq: JsonObject) {
        getCompositeDisposable()?.add(getLinderaService().userLogin(loginReq, object : ResponseListener<Response<BaseResponse<AppUser>>, String> {
            override fun onSuccess(response: Response<BaseResponse<AppUser>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        getSession().setAppUser(it.data)
                        getSession().setAppUserToken(it.token)
                    }
                    getNavigator()?.onMainScreen()
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