package com.linderaredux.dagger

import com.linderaredux.ui.change_password.ChangePasswordActivity
import com.linderaredux.ui.change_password.ChangePasswordActivityModule
import com.linderaredux.ui.choose_patient.ChoosePatientActivity
import com.linderaredux.ui.choose_patient.ChoosePatientActivityModule
import com.linderaredux.ui.confirm_account.ConfirmAccountActivity
import com.linderaredux.ui.confirm_account.ConfirmAccountActivityModule
import com.linderaredux.ui.contact.ContactActivity
import com.linderaredux.ui.contact.ContactActivityModule
import com.linderaredux.ui.create_patient.CreatePatientActivity
import com.linderaredux.ui.create_patient.CreatePatientActivityModule
import com.linderaredux.ui.edit_patient.EditPatientActivity
import com.linderaredux.ui.edit_patient.EditPatientActivityModule
import com.linderaredux.ui.delete_account.DeleteAccountActivity
import com.linderaredux.ui.delete_account.DeleteAccountActivityModule
import com.linderaredux.ui.facility.FacilityActivity
import com.linderaredux.ui.facility.FacilityActivityModule
import com.linderaredux.ui.imprint.ImprintActivity
import com.linderaredux.ui.imprint.ImprintActivityModule
import com.linderaredux.ui.landing.LandingActivity
import com.linderaredux.ui.landing.LandingActivityModule
import com.linderaredux.ui.login.LoginActivity
import com.linderaredux.ui.login.LoginActivityModule
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.main.MainActivityModule
import com.linderaredux.ui.main.analyse.AnalyseFragmentProvider
import com.linderaredux.ui.main.analyse.archive.ArchiveFragmentProvider
import com.linderaredux.ui.main.analyse.processing.ProcessingFragmentProvider
import com.linderaredux.ui.main.analyse.upload.UploadFragmentProvider
import com.linderaredux.ui.main.home.HomeFragmentProvider
import com.linderaredux.ui.main.more.MoreFragmentProvider
import com.linderaredux.ui.main.patient.PatientFragmentProvider
import com.linderaredux.ui.privacy_policy.PrivacyPolicyActivity
import com.linderaredux.ui.privacy_policy.PrivacyPolicyActivityModule
import com.linderaredux.ui.profile.ProfileActivity
import com.linderaredux.ui.profile.ProfileActivityModule
import com.linderaredux.ui.register.RegisterActivity
import com.linderaredux.ui.register.RegisterActivityModule
import com.linderaredux.ui.splash.SplashActivity
import com.linderaredux.ui.splash.SplashActivityModule
import com.linderaredux.ui.start_analysis.StartAnalysisActivity
import com.linderaredux.ui.start_analysis.StartAnalysisActivityModule
import com.linderaredux.ui.terms_of_use.TermsOfUseActivity
import com.linderaredux.ui.terms_of_use.TermsOfUseActivityModule
import com.linderaredux.ui.tutorial_video.TutorialVideoActivity
import com.linderaredux.ui.tutorial_video.TutorialVideoActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LandingActivityModule::class])
    internal abstract fun bindLandingActivity(): LandingActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [RegisterActivityModule::class])
    internal abstract fun bindRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector(modules = [ConfirmAccountActivityModule::class])
    internal abstract fun bindConfirmAccountActivity(): ConfirmAccountActivity

    @ContributesAndroidInjector(modules = [EditPatientActivityModule::class])
    internal abstract fun bindEditPatientActivity(): EditPatientActivity

    @ContributesAndroidInjector(modules = [CreatePatientActivityModule::class])
    internal abstract fun bindCreatePatientActivity(): CreatePatientActivity

    @ContributesAndroidInjector(
            modules = [MainActivityModule::class,
                HomeFragmentProvider::class,
                MoreFragmentProvider::class,
                PatientFragmentProvider::class,
                AnalyseFragmentProvider::class,
                ProcessingFragmentProvider::class,
                UploadFragmentProvider::class,
                ArchiveFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ContactActivityModule::class])
    internal abstract fun bindContactActivity(): ContactActivity

    @ContributesAndroidInjector(modules = [ProfileActivityModule::class])
    internal abstract fun bindProfileActivity(): ProfileActivity

    @ContributesAndroidInjector(modules = [FacilityActivityModule::class])
    internal abstract fun bindFacilityActivity(): FacilityActivity

    @ContributesAndroidInjector(modules = [DeleteAccountActivityModule::class])
    internal abstract fun bindDeleteAccountActivity(): DeleteAccountActivity

    @ContributesAndroidInjector(modules = [PrivacyPolicyActivityModule::class])
    internal abstract fun bindPrivacyPolicyActivity(): PrivacyPolicyActivity

    @ContributesAndroidInjector(modules = [ImprintActivityModule::class])
    internal abstract fun bindImprintActivity(): ImprintActivity

    @ContributesAndroidInjector(modules = [TermsOfUseActivityModule::class])
    internal abstract fun bindTermsOfUseActivity(): TermsOfUseActivity

    @ContributesAndroidInjector(modules = [TutorialVideoActivityModule::class])
    internal abstract fun bindTutorialVideoActivity(): TutorialVideoActivity

    @ContributesAndroidInjector(modules = [ChangePasswordActivityModule::class])
    internal abstract fun bindChangePasswordActivity(): ChangePasswordActivity

    @ContributesAndroidInjector(modules = [ChoosePatientActivityModule::class])
    internal abstract fun bindChoosePatientActivity(): ChoosePatientActivity

    @ContributesAndroidInjector(modules = [StartAnalysisActivityModule::class])
    internal abstract fun bindStartAnalysisActivity(): StartAnalysisActivity
}