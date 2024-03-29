package com.linderaredux.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivitySplashBinding
import com.linderaredux.ui.landing.LandingActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.register.RegisterViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import io.sentry.Sentry
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

    @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: SplashViewModel
        get() = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java)

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
        viewModel.setNavigator(this)

        //Send Event
        try {
            unsafeMethod()
        } catch (e: Exception) {
            Sentry.capture(e)
        }

        viewModel.onTimeHandler()
    }

    override fun onLandingScreen() {
        val intent = LandingActivity.newIntent(this)
        startActivity(intent)
        finish()
    }

    override fun onMainScreen() {
        val intent = MainActivity.newIntent(this)
        startActivity(intent)
        finish()
    }

    /**
     * An example method that throws an exception.
     */
    private fun unsafeMethod() {
        throw UnsupportedOperationException("You shouldn't call this!")
    }
}