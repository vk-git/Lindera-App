package com.linderaredux.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityLandingBinding
import com.linderaredux.databinding.ActivityLoginBinding
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.register.RegisterActivity
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: LoginViewModel? = null

    private var mActivityLoginBinding: ActivityLoginBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityLoginBinding!!.toolbar.setBackButton(true)
        mActivityLoginBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }

    override fun onLoginHandle() {
        val intent = MainActivity.newIntent(this)
        startActivity(intent)
    }

    override fun onRegisterScreen() {
        val intent = RegisterActivity.newIntent(this)
        startActivity(intent)
    }
}