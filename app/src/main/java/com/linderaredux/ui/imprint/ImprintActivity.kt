package com.linderaredux.ui.imprint

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityContactBinding
import com.linderaredux.databinding.ActivityImprintBinding
import com.linderaredux.ui.facility.FacilityViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class ImprintActivity : BaseActivity<ActivityImprintBinding, ImprintViewModel>(), ImprintNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ImprintActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: ImprintViewModel
        get() = ViewModelProviders.of(this, factory).get(ImprintViewModel::class.java)

    private var mActivityImprintBinding: ActivityImprintBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_imprint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityImprintBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityImprintBinding!!.toolbar.setBackButton(true)
        mActivityImprintBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }
}