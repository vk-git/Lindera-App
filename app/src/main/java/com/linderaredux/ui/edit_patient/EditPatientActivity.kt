package com.linderaredux.ui.edit_patient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityEditPatientBinding
import com.linderaredux.utils.Constant
import javax.inject.Inject

class EditPatientActivity : BaseActivity<ActivityEditPatientBinding, EditPatientViewModel>(), EditPatientNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, EditPatientActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: EditPatientViewModel? = null

    private var mActivityEditPatientBinding: ActivityEditPatientBinding? = null

    private lateinit var patient: Patient

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_edit_patient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityEditPatientBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        patient = intent.getParcelableExtra(Constant.PARAM_PATIENT) as Patient

        mActivityEditPatientBinding!!.toolbar.setBackButton(true)
        mActivityEditPatientBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })

        patient?.let {
            Log.d("mytag", "patient::" + Gson().toJson(it))
            mActivityEditPatientBinding!!.etName.setText("${it.firstname} ${it.firstname}")
            mActivityEditPatientBinding!!.etAge.setText("${it.age}")
            mActivityEditPatientBinding!!.spinGender.setSelection(getGenderWithKey(it.sex!!))
        }
    }

    private fun getGenderWithKey(gender: String): Int {
        return if (gender == "m") {
            0
        } else {
            1
        }
    }
}