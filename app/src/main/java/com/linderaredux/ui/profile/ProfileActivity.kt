package com.linderaredux.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityProfileBinding
import com.linderaredux.ui.privacy_policy.PrivacyPolicyViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class ProfileActivity : BaseActivity<ActivityProfileBinding, ProfileViewModel>(), ProfileNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: ProfileViewModel
        get() = ViewModelProviders.of(this, factory).get(ProfileViewModel::class.java)

    private var mActivityProfileBinding: ActivityProfileBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityProfileBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityProfileBinding!!.toolbar.setBackButton(true)
        mActivityProfileBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })

        setProfileData()
    }

    private fun setProfileData() {
        viewModel!!.getSession().getAppUser()?.let {
            mActivityProfileBinding!!.etFirstName.setText(it.firstname)
            mActivityProfileBinding!!.etSurname.setText(it.lastname)
            mActivityProfileBinding!!.etUsername.setText(it.username)
            mActivityProfileBinding!!.etEmail.setText(it.email)
        }
    }
}