package com.linderaredux.ui.create_patient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityCreatePatientBinding
import com.linderaredux.ui.contact.ContactViewModel
import com.linderaredux.ui.edit_patient.EditPatientActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.utils.Constant
import com.linderaredux.utils.Validation
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class CreatePatientActivity : BaseActivity<ActivityCreatePatientBinding, CreatePatientViewModel>(), CreatePatientNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreatePatientActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: CreatePatientViewModel
        get() = ViewModelProviders.of(this, factory).get(CreatePatientViewModel::class.java)

    private var mActivityCreatePatientBinding: ActivityCreatePatientBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_create_patient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityCreatePatientBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityCreatePatientBinding!!.toolbar.setBackButton(true)
        mActivityCreatePatientBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
        mActivityCreatePatientBinding!!.toolbar.setRightButtonListener(listener = View.OnClickListener {
            onSaveHandle()
        })

        mActivityCreatePatientBinding!!.etFirstName.addTextChangedListener(Validation(mActivityCreatePatientBinding!!.etFirstName, Validation.ValidationType.CompanyName))
        mActivityCreatePatientBinding!!.etLastName.addTextChangedListener(Validation(mActivityCreatePatientBinding!!.etLastName, Validation.ValidationType.CompanyName))
        mActivityCreatePatientBinding!!.etAge.addTextChangedListener(Validation(mActivityCreatePatientBinding!!.etAge, Validation.ValidationType.CompanyName))
        mActivityCreatePatientBinding!!.etHeight.addTextChangedListener(Validation(mActivityCreatePatientBinding!!.etHeight, Validation.ValidationType.CompanyName))
        mActivityCreatePatientBinding!!.etWeight.addTextChangedListener(Validation(mActivityCreatePatientBinding!!.etWeight, Validation.ValidationType.CompanyName))

        val livingCondition = resources.getStringArray(R.array.living_condition)
        val livingConditionAdapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, livingCondition)
        mActivityCreatePatientBinding!!.spinnerLivingCondition.setAdapter(livingConditionAdapter)

        val dementia = resources.getStringArray(R.array.dementia)
        val dementiaAdapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, dementia)
        mActivityCreatePatientBinding!!.spinnerDementia.setAdapter(dementiaAdapter)

        val gender = resources.getStringArray(R.array.gender)
        val genderAdapter = ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line, gender)
        mActivityCreatePatientBinding!!.spinnerGender.setAdapter(genderAdapter)
    }

    override fun onSaveHandle() {
        if (valid()) {
            val patientReq = JsonObject()
            patientReq.addProperty("firstname", mActivityCreatePatientBinding!!.etFirstName.text.toString())
            patientReq.addProperty("lastname", mActivityCreatePatientBinding!!.etLastName.text.toString())
            patientReq.addProperty("age", mActivityCreatePatientBinding!!.etAge.text.toString())
            patientReq.addProperty("height", mActivityCreatePatientBinding!!.etHeight.text.toString())
            patientReq.addProperty("weight", mActivityCreatePatientBinding!!.etWeight.text.toString())
            patientReq.addProperty("sex", getGender())
            patientReq.addProperty("residential_form", getLivingCondition())
            patientReq.addProperty("hasDementia", getDementia())
            patientReq.addProperty("userID", viewModel!!.getSession().getAppUser().Id)
            patientReq.add("answerquestionnaire", JsonArray())
            viewModel?.userCreatePatient(patientReq)
        }
    }

    private fun valid(): Boolean {
        var validInput = true
        val firstName = Validation.removeBadSpaces(mActivityCreatePatientBinding!!.etFirstName.text.toString())
        val lastname = Validation.removeBadSpaces(mActivityCreatePatientBinding!!.etLastName.text.toString())
        val age = Validation.removeBadSpaces(mActivityCreatePatientBinding!!.etAge.text.toString())
        val height = Validation.removeBadSpaces(mActivityCreatePatientBinding!!.etHeight.text.toString())
        val weight = Validation.removeBadSpaces(mActivityCreatePatientBinding!!.etWeight.text.toString())

        if (!Validation.isValidName(firstName)) {
            validInput = false
            mActivityCreatePatientBinding!!.tIFirstName.isErrorEnabled = true
            mActivityCreatePatientBinding!!.tIFirstName.error = "The first name may only consist of letters"
        } else {
            mActivityCreatePatientBinding!!.tIFirstName.isErrorEnabled = false
        }

        if (!Validation.isValidName(lastname)) {
            validInput = false
            mActivityCreatePatientBinding!!.tILastName.isErrorEnabled = true
            mActivityCreatePatientBinding!!.tILastName.error = "The last name may only consist of letters"
        } else {
            mActivityCreatePatientBinding!!.tILastName.isErrorEnabled = false
        }

        if (age.isEmpty() || (!Validation.isValidNumber(age) && age.toInt() == 0)) {
            validInput = false
            mActivityCreatePatientBinding!!.tIAge.isErrorEnabled = true
            mActivityCreatePatientBinding!!.tIAge.error = "Age (year)"
        } else {
            mActivityCreatePatientBinding!!.tIAge.isErrorEnabled = false
        }

        if (height.isEmpty() || (!Validation.isValidNumber(height) && height.toInt() == 0)) {
            validInput = false
            mActivityCreatePatientBinding!!.tIHeight.isErrorEnabled = true
            mActivityCreatePatientBinding!!.tIHeight.error = "Height(cm)"
        } else {
            mActivityCreatePatientBinding!!.tIHeight.isErrorEnabled = false
        }

        if (weight.isEmpty() || (!Validation.isValidNumber(weight) && weight.toInt() == 0)) {
            validInput = false
            mActivityCreatePatientBinding!!.tIWeight.isErrorEnabled = true
            mActivityCreatePatientBinding!!.tIWeight.error = "Weight(kg)"
        } else {
            mActivityCreatePatientBinding!!.tIWeight.isErrorEnabled = false
        }

        return validInput
    }

    override fun onSuccessfullyCreated(patient: Patient) {
        val intent = EditPatientActivity.newIntent(this)
        intent.putExtra(Constant.PARAM_PATIENT, patient)
        startActivity(intent)
        finish()
    }

    private fun getGender(): String {
        return if (mActivityCreatePatientBinding!!.spinnerDementia.text.toString() == getString(R.string.man)) {
            "m"
        } else {
            "w"
        }
    }

    private fun getLivingCondition(): String {
        val livingCondition = resources.getStringArray(R.array.living_condition)
        return when {
            mActivityCreatePatientBinding!!.spinnerLivingCondition.text.toString() == livingCondition[0] -> "alone"
            mActivityCreatePatientBinding!!.spinnerLivingCondition.text.toString() == livingCondition[1] -> "together_with_relatives"
            mActivityCreatePatientBinding!!.spinnerLivingCondition.text.toString() == livingCondition[2] -> "assisted_living"
            mActivityCreatePatientBinding!!.spinnerLivingCondition.text.toString() == livingCondition[3] -> "seniorhome"
            else -> "alone"
        }
    }

    private fun getDementia(): Boolean {
        val dementia = resources.getStringArray(R.array.dementia)
        return when {
            mActivityCreatePatientBinding!!.spinnerDementia.text.toString() == dementia[0] -> true
            mActivityCreatePatientBinding!!.spinnerDementia.text.toString() == dementia[1] -> false
            else -> false
        }
    }
}