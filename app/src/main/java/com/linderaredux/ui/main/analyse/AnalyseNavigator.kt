package com.linderaredux.ui.main.analyse

import com.linderaredux.base.BaseNavigator

interface AnalyseNavigator : BaseNavigator {
    fun handleError(error: String)
}