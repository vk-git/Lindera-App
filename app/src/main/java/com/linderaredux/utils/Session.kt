package com.linderaredux.utils

import android.content.Context
import android.content.SharedPreferences

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

    fun logout() {
        editor.clear()
        editor.commit()
    }

    object Key {
        internal const val APP_USER = "app_user"
    }
}