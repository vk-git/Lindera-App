package com.linderaredux.base

interface BaseNavigator {
    fun handleError(error: String)
    fun onInternetConnectionError()
}