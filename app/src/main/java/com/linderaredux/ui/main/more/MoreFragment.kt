package com.linderaredux.ui.main.more

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentMoreBinding
import com.linderaredux.ui.change_password.ChangePasswordActivity
import com.linderaredux.ui.contact.ContactActivity
import com.linderaredux.ui.delete_account.DeleteAccountActivity
import com.linderaredux.ui.facility.FacilityActivity
import com.linderaredux.ui.imprint.ImprintActivity
import com.linderaredux.ui.landing.LandingActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.privacy_policy.PrivacyPolicyActivity
import com.linderaredux.ui.profile.ProfileActivity
import com.linderaredux.ui.terms_of_use.TermsOfUseActivity
import com.linderaredux.ui.tutorial_video.TutorialVideoActivity
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>(), MoreNavigator {

    companion object {
        fun newInstance(): MoreFragment {
            val args = Bundle()
            val fragment = MoreFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: MoreViewModel
        get() = ViewModelProviders.of(this, factory).get(MoreViewModel::class.java)

    private var mFragmentMoreBinding: FragmentMoreBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_more

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentMoreBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("More")
        (activity as MainActivity).showToolbarRightText(false)

        loadUserData()
    }

    private fun loadUserData() {
        viewModel.getSession().getAppUser()?.let {
            mFragmentMoreBinding!!.txtUserName.text = "${it.firstname} ${it.lastname}"
            mFragmentMoreBinding!!.txtUserStatus.text = "${it.status}"
        }
        viewModel.getSession().getAppUserHome()?.let {
            mFragmentMoreBinding!!.txtAppUserHome.text = "${it.name}"
        }
    }

    override fun onProfileScreen() {
        val intent = activity?.let { ProfileActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onFacilityScreen() {
        val intent = activity?.let { FacilityActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onHowRecordAnalysisScreen() {
        val intent = activity?.let { TutorialVideoActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onChangePasswordScreen() {
        val intent = activity?.let { ChangePasswordActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onFeedBackScreen() {

    }

    override fun onContactScreen() {
        val intent = activity?.let { ContactActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onFAQScreen() {

    }

    override fun onTeamsOfUseScreen() {
        val intent = activity?.let { TermsOfUseActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onPrivacyPolicyScreen() {
        val intent = activity?.let { PrivacyPolicyActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onDeleteAccountScreen() {
        val intent = activity?.let { DeleteAccountActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onImprintScreen() {
        val intent = activity?.let { ImprintActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onLogout() {
        val intent = LandingActivity.newIntent(context!!)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}