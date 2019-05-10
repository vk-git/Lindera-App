package com.linderaredux.ui.privacy_policy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityContactBinding
import com.linderaredux.databinding.ActivityPrivacyPolicyBinding
import com.linderaredux.ui.main.MainViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class PrivacyPolicyActivity : BaseActivity<ActivityPrivacyPolicyBinding, PrivacyPolicyViewModel>(), PrivacyPolicyNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, PrivacyPolicyActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: PrivacyPolicyViewModel
        get() = ViewModelProviders.of(this, factory).get(PrivacyPolicyViewModel::class.java)

    private var mActivityPrivacyPolicyBinding: ActivityPrivacyPolicyBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_privacy_policy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityPrivacyPolicyBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityPrivacyPolicyBinding!!.toolbar.setBackButton(true)
        mActivityPrivacyPolicyBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }
}