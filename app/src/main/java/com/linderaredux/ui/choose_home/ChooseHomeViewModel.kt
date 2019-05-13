package com.linderaredux.ui.choose_home

import android.app.Application
import com.google.gson.reflect.TypeToken
import com.linderaredux.api.ResponseListener
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.response.UserHome
import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import com.linderaredux.utils.SharedPreferenceHelper
import retrofit2.Response

class ChooseHomeViewModel(application: Application, linderaService: LinderaService, session: Session, dataManager: DataManager) : BaseViewModel<ChooseHomeNavigator>(application, linderaService, session, dataManager) {

    fun userHomes(query: String) {
        getCompositeDisposable()?.add(getLinderaService().userHomes(query, object : ResponseListener<Response<BaseResponse<List<UserHome>>>, String> {
            override fun onSuccess(response: Response<BaseResponse<List<UserHome>>>) {
                if (response.isSuccessful) {
                    response.body()?.run {
                        getNavigator()?.getUserHomeList(data)
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