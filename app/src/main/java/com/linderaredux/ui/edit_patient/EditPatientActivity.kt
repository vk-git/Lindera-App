package com.linderaredux.ui.edit_patient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityEditPatientBinding
import com.linderaredux.extensions.disable
import com.linderaredux.extensions.enable
import com.linderaredux.extensions.gone
import com.linderaredux.extensions.visible
import com.linderaredux.ui.delete_account.DeleteAccountViewModel
import com.linderaredux.ui.start_analysis.StartAnalysisActivity
import com.linderaredux.utils.Constant
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class EditPatientActivity : BaseActivity<ActivityEditPatientBinding, EditPatientViewModel>(), EditPatientNavigator {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, EditPatientActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: EditPatientViewModel
        get() = ViewModelProviders.of(this, factory).get(EditPatientViewModel::class.java)

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

        with(mActivityEditPatientBinding!!.toolbar) {
            setToolbarTitle(getString(R.string.edit_patient_title))
            setBackButton(true)
            setBackButtonListener(listener = View.OnClickListener {
                finish()
            })
            setRightButtonListener(listener = View.OnClickListener {
                if (getRightText() == getString(R.string.patient_edit)) {
                    setOnEditMode(true)
                } else {
                    setOnEditMode(false)
                }
            })
        }

        var genderList = resources.getStringArray(R.array.gender)
        var genderAdapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, genderList)
        mActivityEditPatientBinding!!.spinGender.setAdapter(genderAdapter)

        var hospitalList = resources.getStringArray(R.array.hospital)
        var hospitalAdapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, hospitalList)
        mActivityEditPatientBinding!!.spinHospital.setAdapter(hospitalAdapter)

        patient?.run {
            mActivityEditPatientBinding!!.etName.setText("$firstname $firstname")
            mActivityEditPatientBinding!!.etAge.setText("$age")
            mActivityEditPatientBinding!!.spinGender.setText(getGenderWithKey(sex))
            mActivityEditPatientBinding!!.spinHospital.setText(getHospitality(sex))
        }

        setOnEditMode(false)
    }

    private fun getHospitality(sex: String?): String {
        return ""
    }

    private fun setOnEditMode(isEditMode: Boolean) {
        with(mActivityEditPatientBinding!!) {
            if (isEditMode) {
                etName.enable()
                etAge.enable()
                etWohnform.enable()
                spinGender.enable()
                spinHospital.enable()
                btnStartAnalysis.gone()
                btnButtonSaveLayout.visible()
                toolbar.setRightText(getString(R.string.patient_save))
                toolbar.setToolbarTitle(getString(R.string.edit_patient_edit_title))
            } else {
                etName.disable()
                etAge.disable()
                etWohnform.disable()
                spinGender.disable()
                spinHospital.disable()
                btnStartAnalysis.visible()
                btnButtonSaveLayout.gone()
                toolbar.setRightText(getString(R.string.patient_edit))
                toolbar.setToolbarTitle(getString(R.string.edit_patient_title))
            }
        }
    }

    private fun getGenderWithKey(gender: String): String {
        return if (gender == "m") {
            getString(R.string.man)
        } else {
            getString(R.string.woman)
        }
    }

    override fun onDeletePatient() {
        viewModel?.run {
            deletePatient(patient.id)
        }
    }

    override fun onStartAnalysis() {
        val intent = StartAnalysisActivity.newIntent(this@EditPatientActivity)
        intent.putExtra(Constant.PARAM_PATIENT, patient)
        startActivity(intent)
    }
}