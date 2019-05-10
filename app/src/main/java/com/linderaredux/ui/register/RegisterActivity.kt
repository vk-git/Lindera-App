package com.linderaredux.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.linderaredux.BR
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityRegisterBinding
import com.linderaredux.ui.login.LoginActivity
import javax.inject.Inject
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.R
import com.linderaredux.ui.profile.ProfileViewModel
import com.linderaredux.utils.ViewModelProviderFactory

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>(), RegisterNavigator {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

   @set:Inject
    var factory: ViewModelProviderFactory? = null

    override val viewModel: RegisterViewModel
        get() = ViewModelProviders.of(this, factory).get(RegisterViewModel::class.java)

    private var mActivityRegisterBinding: ActivityRegisterBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_register

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityRegisterBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityRegisterBinding!!.toolbar.setBackButton(true)
        mActivityRegisterBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })

        val list = resources.getStringArray(R.array.position)
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, list)
        mActivityRegisterBinding!!.txtPosition.setAdapter(adapter)
    }

    override fun onLoginScreen() {
        val intent = LoginActivity.newIntent(this)
        startActivity(intent)
    }
}