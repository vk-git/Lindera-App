package com.linderaredux.ui.contact

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityContactBinding
import com.linderaredux.databinding.ActivityLandingBinding
import com.linderaredux.databinding.ActivityLoginBinding
import com.linderaredux.ui.register.RegisterActivity
import javax.inject.Inject

class ContactActivity : BaseActivity<ActivityContactBinding, ContactViewModel>(), ContactNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ContactActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: ContactViewModel? = null

    private var mActivityContactBinding: ActivityContactBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityContactBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityContactBinding!!.toolbar.setBackButton(true)
        mActivityContactBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }

    override fun handleError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show();
    }

    override fun onInternetConnectionError() {
        Toast.makeText(
                applicationContext,
                getString(R.string.please_check_your_internet_connection_or_try_again_later),
                Toast.LENGTH_SHORT
        ).show()
    }
}