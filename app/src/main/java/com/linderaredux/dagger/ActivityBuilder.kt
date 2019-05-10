package com.linderaredux.dagger

import com.linderaredux.ui.change_password.ChangePasswordActivity
import com.linderaredux.ui.choose_patient.ChoosePatientActivity
import com.linderaredux.ui.choose_patient.ChoosePatientActivityModule
import com.linderaredux.ui.confirm_account.ConfirmAccountActivity
import com.linderaredux.ui.contact.ContactActivity
import com.linderaredux.ui.create_patient.CreatePatientActivity
import com.linderaredux.ui.delete_account.DeleteAccountActivity
import com.linderaredux.ui.edit_patient.EditPatientActivity
import com.linderaredux.ui.facility.FacilityActivity
import com.linderaredux.ui.imprint.ImprintActivity
import com.linderaredux.ui.landing.LandingActivity
import com.linderaredux.ui.landing.LandingActivityModule
import com.linderaredux.ui.login.LoginActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.main.analyse.AnalyseFragmentProvider
import com.linderaredux.ui.main.analyse.archive.ArchiveFragmentProvider
import com.linderaredux.ui.main.analyse.processing.ProcessingFragmentProvider
import com.linderaredux.ui.main.analyse.upload.UploadFragmentProvider
import com.linderaredux.ui.main.home.HomeFragmentProvider
import com.linderaredux.ui.main.more.MoreFragmentProvider
import com.linderaredux.ui.main.patient.PatientFragmentProvider
import com.linderaredux.ui.privacy_policy.PrivacyPolicyActivity
import com.linderaredux.ui.profile.ProfileActivity
import com.linderaredux.ui.register.RegisterActivity
import com.linderaredux.ui.splash.SplashActivity
import com.linderaredux.ui.start_analysis.StartAnalysisActivity
import com.linderaredux.ui.terms_of_use.TermsOfUseActivity
import com.linderaredux.ui.tutorial_video.TutorialVideoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LandingActivityModule::class])
    internal abstract fun bindLandingActivity(): LandingActivity

    @ContributesAndroidInjector
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun bindRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector
    internal abstract fun bindConfirmAccountActivity(): ConfirmAccountActivity

    @ContributesAndroidInjector
    internal abstract fun bindEditPatientActivity(): EditPatientActivity

    @ContributesAndroidInjector
    internal abstract fun bindCreatePatientActivity(): CreatePatientActivity

    @ContributesAndroidInjector(
            modules = [HomeFragmentProvider::class,
                MoreFragmentProvider::class,
                PatientFragmentProvider::class,
                AnalyseFragmentProvider::class,
                ProcessingFragmentProvider::class,
                UploadFragmentProvider::class,
                ArchiveFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindContactActivity(): ContactActivity

    @ContributesAndroidInjector
    internal abstract fun bindProfileActivity(): ProfileActivity

    @ContributesAndroidInjector
    internal abstract fun bindFacilityActivity(): FacilityActivity

    @ContributesAndroidInjector
    internal abstract fun bindDeleteAccountActivity(): DeleteAccountActivity

    @ContributesAndroidInjector
    internal abstract fun bindPrivacyPolicyActivity(): PrivacyPolicyActivity

    @ContributesAndroidInjector
    internal abstract fun bindImprintActivity(): ImprintActivity

    @ContributesAndroidInjector
    internal abstract fun bindTermsOfUseActivity(): TermsOfUseActivity

    @ContributesAndroidInjector
    internal abstract fun bindTutorialVideoActivity(): TutorialVideoActivity

    @ContributesAndroidInjector
    internal abstract fun bindChangePasswordActivity(): ChangePasswordActivity

    @ContributesAndroidInjector(modules = [ChoosePatientActivityModule::class])
    internal abstract fun bindChoosePatientActivity(): ChoosePatientActivity

    @ContributesAndroidInjector
    internal abstract fun bindStartAnalysisActivity(): StartAnalysisActivity
}