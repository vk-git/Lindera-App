package com.linderaredux.ui.start_analysis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityStartAnalysisBinding
import javax.inject.Inject

class StartAnalysisActivity : BaseActivity<ActivityStartAnalysisBinding, StartAnalysisViewModel>(), StartAnalysisNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, StartAnalysisActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: StartAnalysisViewModel? = null

    private var mActivityStartAnalysisBinding: ActivityStartAnalysisBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_start_analysis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityStartAnalysisBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityStartAnalysisBinding!!.toolbar.setBackButton(true)
        mActivityStartAnalysisBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }
}