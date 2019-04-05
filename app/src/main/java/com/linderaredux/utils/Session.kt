package com.linderaredux.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.reflect.TypeToken
import com.linderaredux.api.response.AppUser
import com.linderaredux.api.response.UserHome
import com.linderaredux.utils.Session.Key.APP_USER
import com.linderaredux.utils.Session.Key.APP_USER_HOME
import com.linderaredux.utils.Session.Key.APP_USER_TOKEN

class Session(context: Context) {

    private val PREF_NAME = "private_lindera"
    private val PRIVATE_MODE = 0
    private val pref: SharedPreferences
    private val editor: SharedPreferences.Editor
    private val context: Context = context

    init {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun setAppUser(appUser: AppUser) {
        editor.putString(APP_USER, SharedPreferenceHelper.getStringFromObject(appUser))
        editor.apply()
    }

    fun getAppUser(): AppUser {
        return SharedPreferenceHelper.getObjectFromString(pref.getString(APP_USER, ""), object :
                TypeToken<AppUser>() {
        })
    }
    fun setAppUserHome(userHome: UserHome) {
        editor.putString(APP_USER_HOME, SharedPreferenceHelper.getStringFromObject(userHome))
        editor.apply()
    }

    fun getAppUserHome(): UserHome {
        return SharedPreferenceHelper.getObjectFromString(pref.getString(APP_USER_HOME, ""), object :
                TypeToken<UserHome>() {
        })
    }

    fun setAppUserToken(token: String) {
        editor.putString(APP_USER_TOKEN, token)
        editor.apply()
    }

    fun getAppUserToken(): String {
        return pref.getString(APP_USER_TOKEN, "")
    }

    fun logout() {
        editor.clear()
        editor.commit()
    }

    object Key {
        internal const val APP_USER = "app_user"
        internal const val APP_USER_HOME = "app_user_home"
        internal const val APP_USER_TOKEN = "app_user_token"
    }
}