package com.linderaredux.ui.landing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.CustomPagerAdapter
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityLandingBinding
import com.linderaredux.ui.login.LoginActivity
import javax.inject.Inject

class LandingActivity : BaseActivity<ActivityLandingBinding, LandingViewModel>(), LandingNavigator {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LandingActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: LandingViewModel? = null

    private var mActivityLandingBinding: ActivityLandingBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_landing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLandingBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        setUpTutorialPage()
    }

    private fun setUpTutorialPage() {
        mActivityLandingBinding!!.viewPager.adapter =  CustomPagerAdapter(this)
    }

    override fun onLoginScreen() {
        val intent = LoginActivity.newIntent(this)
        startActivity(intent)
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