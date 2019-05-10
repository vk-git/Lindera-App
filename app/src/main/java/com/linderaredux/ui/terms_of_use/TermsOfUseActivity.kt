package com.linderaredux.ui.terms_of_use

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityContactBinding
import com.linderaredux.databinding.ActivityTermsOfUseBinding
import com.linderaredux.ui.start_analysis.StartAnalysisViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class TermsOfUseActivity : BaseActivity<ActivityTermsOfUseBinding, TermsOfUseViewModel>(), TermsOfUseNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TermsOfUseActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: TermsOfUseViewModel
        get() = ViewModelProviders.of(this, factory).get(TermsOfUseViewModel::class.java)

    private var mActivityTermsOfUseBinding: ActivityTermsOfUseBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_terms_of_use

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityTermsOfUseBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityTermsOfUseBinding!!.toolbar.setBackButton(true)
        mActivityTermsOfUseBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }
}