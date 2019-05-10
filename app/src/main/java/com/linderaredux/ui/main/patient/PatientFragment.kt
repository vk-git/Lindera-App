package com.linderaredux.ui.main.patient

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.patient.PatientAdapter
import com.linderaredux.adapter.patient.PatientSection
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentPatientBinding
import com.linderaredux.ui.create_patient.CreatePatientActivity
import com.linderaredux.ui.edit_patient.EditPatientActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.utils.Constant
import com.linderaredux.utils.Sort
import com.linderaredux.utils.ViewModelProviderFactory
import com.linderaredux.view.Alphabetik
import org.zakariya.stickyheaders.StickyHeaderLayoutManager
import javax.inject.Inject


class PatientFragment : BaseFragment<FragmentPatientBinding, PatientViewModel>(), PatientNavigator {

    companion object {
        fun newInstance(): PatientFragment {
            val args = Bundle()
            val fragment = PatientFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: PatientViewModel
        get() = ViewModelProviders.of(this, factory).get(PatientViewModel::class.java)

    @set:Inject
    var mPatientAdapter: PatientAdapter? = null

    private var mFragmentPatientBinding: FragmentPatientBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_patient

    var patientSections = ArrayList<PatientSection>()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentPatientBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("Patients")
        (activity as MainActivity).showToolbarRightText(false)
        (activity as MainActivity).loadPatientsData()

        viewModel?.run {
            getDataManager().allPatients.observe(this@PatientFragment, Observer<List<Patient>> { patientList ->
                setPatientData(patientList)
            })
        }
    }

    private fun setPatientData(patientList: List<Patient>) {
        with(mFragmentPatientBinding!!.recyclerView) {
            layoutManager = StickyHeaderLayoutManager()
            adapter = mPatientAdapter
        }

        patientList?.run {
            val patientSectionList = Sort.onPatientListWithAlphabeticalSection(this)

            patientSections = patientSectionList
            patientSections?.run {
                mPatientAdapter?.setPatientSections(this)
            }

            mPatientAdapter!!.setOnPatientItemListener(object : PatientAdapter.OnPatientItemListener {
                override fun onItemClick(patient: Patient) {
                    val intent = EditPatientActivity.newIntent(activity as MainActivity)
                    intent.putExtra(Constant.PARAM_PATIENT, patient)
                    startActivity(intent)
                }
            })
        }

        mFragmentPatientBinding!!.createNewPatientLayout.setOnClickListener {
            val intent = CreatePatientActivity.newIntent(activity as MainActivity)
            startActivity(intent)
        }

        mFragmentPatientBinding!!.alphabetView.onSectionIndexClickListener(object : Alphabetik.SectionIndexClickListener {
            override fun onItemClick(view: View, position: Int, character: String) {
                val scrollIndex = getPositionFromData(character)
                if (scrollIndex != -1) {
                    val scrollToPosition = mPatientAdapter?.getAdapterPositionForSectionHeader(scrollIndex)
                    if (scrollToPosition != -1)
                        mFragmentPatientBinding!!.recyclerView.scrollToPosition(scrollToPosition!!)
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