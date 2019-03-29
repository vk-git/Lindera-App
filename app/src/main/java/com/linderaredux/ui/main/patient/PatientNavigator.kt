package com.linderaredux.ui.main.patient

import com.linderaredux.base.BaseNavigator

interface PatientNavigator : BaseNavigator {
    fun handleError(error: String)
}