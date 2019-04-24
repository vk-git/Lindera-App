package com.linderaredux.ui.choose_patient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.patient.PatientAdapter
import com.linderaredux.adapter.patient.PatientSection
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityChoosePatientBinding
import com.linderaredux.view.Alphabetik
import org.zakariya.stickyheaders.StickyHeaderLayoutManager
import java.util.*
import javax.inject.Inject

class ChoosePatientActivity : BaseActivity<ActivityChoosePatientBinding, ChoosePatientViewModel>(), ChoosePatientNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ChoosePatientActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: ChoosePatientViewModel? = null

    @set:Inject
    var mPatientAdapter: PatientAdapter? = null

    private var mActivityChoosePatientBinding: ActivityChoosePatientBinding? = null

    var patientSections = ArrayList<PatientSection>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_choose_patient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityChoosePatientBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityChoosePatientBinding!!.toolbar.setBackButton(true)
        mActivityChoosePatientBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })

        setPatientData()
    }

    private fun setPatientData() {
        mActivityChoosePatientBinding!!.recyclerView.layoutManager = StickyHeaderLayoutManager()
        mActivityChoosePatientBinding!!.recyclerView.adapter = mPatientAdapter

        patientSections = viewModel!!.getSession().getPatientList()
        patientSections?.let {
            mPatientAdapter?.setPatientSections(it)
        }

        mPatientAdapter!!.setOnPatientItemListener(object : PatientAdapter.OnPatientItemListener {
            override fun onItemClick(patient: Patient) {
                Toast.makeText(applicationContext, patient.firstname, Toast.LENGTH_SHORT).show()
            }
        })

        mActivityChoosePatientBinding!!.alphabetView.onSectionIndexClickListener(object : Alphabetik.SectionIndexClickListener {
            override fun onItemClick(view: View, position: Int, character: String) {
                val scrollIndex = getPositionFromData(character)
                if (scrollIndex != -1) {
                    val scrollToPosition = mPatientAdapter?.getAdapterPositionForSectionHeader(scrollIndex)
                    if (scrollToPosition != -1)
                        mActivityChoosePatientBinding!!.recyclerView.scrollToPosition(scrollToPosition!!)
                }
            }
        })
    }

    private fun getPositionFromData(character: String): Int {
        for ((position, patientSection) in patientSections.withIndex()) {
            val letter = patientSection.headerTitle
            if (letter == character) {
                return position
            }
        }
        return -1
    }
}