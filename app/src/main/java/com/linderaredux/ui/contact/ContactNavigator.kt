package com.linderaredux.ui.contact

import com.linderaredux.base.BaseNavigator


interface ContactNavigator : BaseNavigator {

    fun handleError(error: String)
}