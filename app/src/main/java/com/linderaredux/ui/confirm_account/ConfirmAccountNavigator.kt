package com.linderaredux.ui.confirm_account

import com.linderaredux.base.BaseNavigator


interface ConfirmAccountNavigator : BaseNavigator {

    fun handleError(error: String)
}