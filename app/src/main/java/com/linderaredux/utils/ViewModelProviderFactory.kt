package com.linderaredux.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.linderaredux.api.service.LinderaService
import com.linderaredux.db.DataManager
import com.linderaredux.ui.change_password.ChangePasswordViewModel
import com.linderaredux.ui.choose_patient.ChoosePatientViewModel
import com.linderaredux.ui.confirm_account.ConfirmAccountViewModel
import com.linderaredux.ui.contact.ContactViewModel
import com.linderaredux.ui.create_patient.CreatePatientViewModel
import com.linderaredux.ui.delete_account.DeleteAccountViewModel
import com.linderaredux.ui.edit_patient.EditPatientViewModel
import com.linderaredux.ui.facility.FacilityViewModel
import com.linderaredux.ui.imprint.ImprintViewModel
import com.linderaredux.ui.landing.LandingViewModel
import com.linderaredux.ui.login.LoginViewModel
import com.linderaredux.ui.main.MainViewModel
import com.linderaredux.ui.main.analyse.AnalyseViewModel
import com.linderaredux.ui.main.analyse.archive.ArchiveViewModel
import com.linderaredux.ui.main.analyse.processing.ProcessingViewModel
import com.linderaredux.ui.main.analyse.upload.UploadViewModel
import com.linderaredux.ui.main.home.HomeViewModel
import com.linderaredux.ui.main.more.MoreViewModel
import com.linderaredux.ui.main.patient.PatientViewModel
import com.linderaredux.ui.privacy_policy.PrivacyPolicyViewModel
import com.linderaredux.ui.profile.ProfileViewModel
import com.linderaredux.ui.register.RegisterViewModel
import com.linderaredux.ui.splash.SplashViewModel
import com.linderaredux.ui.start_analysis.StartAnalysisViewModel
import com.linderaredux.ui.terms_of_use.TermsOfUseViewModel
import com.linderaredux.ui.tutorial_video.TutorialVideoViewModel
import io.reactivex.disposables.CompositeDisposable

class ViewModelProviderFactory : ViewModelProvider.Factory {

    private var mDataManager: DataManager

    private var mApplication: Application

    private var mLinderaService: LinderaService

    private var mSession: Session

    private var mCompositeDisposable: CompositeDisposable

    constructor(application: Application, linderaService: LinderaService, session: Session, mDataManager: DataManager) {
        this.mApplication = application
        this.mLinderaService = linderaService
        this.mSession = session
        this.mCompositeDisposable = CompositeDisposable()
        this.mDataManager = mDataManager
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChangePasswordViewModel::class.java)) {
            return ChangePasswordViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ChoosePatientViewModel::class.java)) {
            return ChoosePatientViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ConfirmAccountViewModel::class.java)) {
            return ConfirmAccountViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(CreatePatientViewModel::class.java)) {
            return CreatePatientViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(DeleteAccountViewModel::class.java)) {
            return DeleteAccountViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(EditPatientViewModel::class.java)) {
            return EditPatientViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(FacilityViewModel::class.java)) {
            return FacilityViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ImprintViewModel::class.java)) {
            return ImprintViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(LandingViewModel::class.java)) {
            return LandingViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(PrivacyPolicyViewModel::class.java)) {
            return PrivacyPolicyViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(StartAnalysisViewModel::class.java)) {
            return StartAnalysisViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(TermsOfUseViewModel::class.java)) {
            return TermsOfUseViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(TutorialVideoViewModel::class.java)) {
            return TutorialVideoViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(PatientViewModel::class.java)) {
            return PatientViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(MoreViewModel::class.java)) {
            return MoreViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(AnalyseViewModel::class.java)) {
            return AnalyseViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ArchiveViewModel::class.java)) {
            return ArchiveViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(ProcessingViewModel::class.java)) {
            return ProcessingViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        } else if (modelClass.isAssignableFrom(UploadViewModel::class.java)) {
            return UploadViewModel(mApplication, mLinderaService, mSession, mDataManager) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}