package com.linderaredux.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.JsonObject
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityLoginBinding
import com.linderaredux.ui.confirm_account.ConfirmAccountActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.register.RegisterActivity
import com.linderaredux.utils.Validation
import com.linderaredux.utils.Validation.ValidationType
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

        mActivityLoginBinding!!.txtUserName.addTextChangedListener(Validation(mActivityLoginBinding!!.txtUserName, ValidationType.Email))
        mActivityLoginBinding!!.txtUserPassword.addTextChangedListener(Validation(mActivityLoginBinding!!.txtUserPassword, ValidationType.Password))
    }

    override fun onLoginHandle() {
        val loginReq = JsonObject()
        loginReq.addProperty("email", mActivityLoginBinding!!.txtUserName.text.toString())
        loginReq.addProperty("password", mActivityLoginBinding!!.txtUserPassword.text.toString())
        viewModel?.login(loginReq)
    }

    override fun onMainScreen() {
        viewModel?.let {
            if (it.getSession().getAppUser().status != "registered") {
                val intent = ConfirmAccountActivity.newIntent(this)
                startActivity(intent)
            } else {
                val intent = MainActivity.newIntent(this)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onRegisterScreen() {
        val intent = RegisterActivity.newIntent(this)
        startActivity(intent)
    }
}