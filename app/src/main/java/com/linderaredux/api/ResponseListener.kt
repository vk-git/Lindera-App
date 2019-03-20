package com.linderaredux.api

interface ResponseListener<S, E> {
    fun onSuccess(response: S)
    fun onInternetConnectionError()
    fun onFailure(error: E)
}