package com.linderaredux.ui.change_password

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityChangePasswordBinding
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject


class ChangePasswordActivity : BaseActivity<ActivityChangePasswordBinding, ChangePasswordViewModel>(), ChangePasswordNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ChangePasswordActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: ChangePasswordViewModel
        get() = ViewModelProviders.of(this, factory).get(ChangePasswordViewModel::class.java)

    private var mActivityChangePasswordBinding: ActivityChangePasswordBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_change_password

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityChangePasswordBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityChangePasswordBinding!!.toolbar.setBackButton(true)
        mActivityChangePasswordBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
        mActivityChangePasswordBinding!!.toolbar.setRightButtonListener(listener = View.OnClickListener {

        })
    }
}