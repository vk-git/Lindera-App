package com.linderaredux.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityLandingBinding
import com.linderaredux.databinding.ActivitySplashBinding
import com.linderaredux.ui.landing.LandingActivity
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: SplashViewModel? = null

    private var mActivitySplashBinding: ActivitySplashBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = true

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivitySplashBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        viewModel?.onTimeHandler()
    }

    override fun onLandingScreen() {
        val intent = LandingActivity.newIntent(this)
        startActivity(intent)
        finish()
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