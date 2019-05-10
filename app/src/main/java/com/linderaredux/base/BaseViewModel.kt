package com.linderaredux.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.utils.Session
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference


abstract class BaseViewModel<N> : AndroidViewModel {

    private val mDataManager: DataManager

    private lateinit var mNavigator: WeakReference<N>

    private var mLinderaService: LinderaService

    private var mSession: Session

    private var mCompositeDisposable: CompositeDisposable

    private val mIsLoading = ObservableBoolean(false)
    private val mIsEmptyView = ObservableBoolean(false)

    val allPatients: LiveData<List<Patient>>
        get() =  getDataManager().allPatients

    constructor(application: Application, linderaService: LinderaService, session: Session, mDataManager: DataManager) : super(application) {
        this.mLinderaService = linderaService
        this.mSession = session
        this.mCompositeDisposable = CompositeDisposable()
        this.mDataManager = mDataManager
    }

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }

    fun getCompositeDisposable(): CompositeDisposable? {
        return mCompositeDisposable
    }

    fun getNavigator(): N? {
        return mNavigator.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

    fun getIsEmptyView(): ObservableBoolean {
        return mIsEmptyView
    }

    fun setIsEmptyView(isEmptyView: Boolean) {
        mIsEmptyView.set(isEmptyView)
    }

    fun getLinderaService(): LinderaService {
        return mLinderaService
    }

    fun getSession(): Session {
        return mSession
    }

    fun getDataManager(): DataManager {
        return mDataManager
    }
}