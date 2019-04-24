package com.linderaredux.ui.contact

import com.linderaredux.api.service.LinderaService
import com.linderaredux.base.BaseViewModel
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session


class ContactViewModel(linderaService: LinderaService, session: Session,dataManager: DataManager) : BaseViewModel<ContactNavigator>(linderaService, session, dataManager) {

}