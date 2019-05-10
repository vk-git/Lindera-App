package com.linderaredux.ui.facility

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityFacilityBinding
import com.linderaredux.ui.edit_patient.EditPatientViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class FacilityActivity : BaseActivity<ActivityFacilityBinding, FacilityViewModel>(), FacilityNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FacilityActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: FacilityViewModel
        get() = ViewModelProviders.of(this, factory).get(FacilityViewModel::class.java)

    private var mActivityFacilityBinding: ActivityFacilityBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_facility

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityFacilityBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityFacilityBinding!!.toolbar.setBackButton(true)
        mActivityFacilityBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })

        setHomeData()
    }

    private fun setHomeData() {
        viewModel!!.getSession().getAppUserHome()?.let {
            mActivityFacilityBinding!!.etCompanyName.setText(it.name)
            mActivityFacilityBinding!!.etCity.setText(it.city)
            mActivityFacilityBinding!!.etStreet.setText(it.street)
            mActivityFacilityBinding!!.etPostCode.setText(it.zip)

            mActivityFacilityBinding!!.etStreetBlur.setText(it.street)
            mActivityFacilityBinding!!.etPostCodeBlur.setText(it.zip)
            mActivityFacilityBinding!!.etCityBlur.setText(it.city)
        }
    }
}