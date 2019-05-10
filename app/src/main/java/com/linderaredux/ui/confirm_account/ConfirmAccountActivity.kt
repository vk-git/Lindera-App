package com.linderaredux.ui.confirm_account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityConfirmAccountBinding
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class ConfirmAccountActivity : BaseActivity<ActivityConfirmAccountBinding, ConfirmAccountViewModel>(), ConfirmAccountNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConfirmAccountActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: ConfirmAccountViewModel
        get() = ViewModelProviders.of(this, factory).get(ConfirmAccountViewModel::class.java)

    private var mActivityConfirmAccountBinding: ActivityConfirmAccountBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_confirm_account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityConfirmAccountBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityConfirmAccountBinding!!.toolbar.setBackButton(true)
        mActivityConfirmAccountBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }
}