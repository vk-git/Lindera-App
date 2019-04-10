package com.linderaredux.ui.main.patient

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.patient.PatientAdapter
import com.linderaredux.adapter.patient.PatientSection
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentPatientBinding
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.view.Alphabetik
import org.zakariya.stickyheaders.StickyHeaderLayoutManager
import java.util.*
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
    var mViewModelFactory: ViewModelProvider.Factory? = null

    @set:Inject
    var mPatientAdapter: PatientAdapter? = null

    private var mFragmentPatientBinding: FragmentPatientBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_patient

    var patientSections = ArrayList<PatientSection>()

    override val viewModel: PatientViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(PatientViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentPatientBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("Patients")

        mFragmentPatientBinding!!.recyclerView.layoutManager = StickyHeaderLayoutManager()
        mFragmentPatientBinding!!.recyclerView.adapter = mPatientAdapter

        patientSections = viewModel.getSession().getPatientList()
        if (patientSections != null) {
            mPatientAdapter?.setPatientSections(patientSections)
        }

        mFragmentPatientBinding!!.alphabetView.onSectionIndexClickListener(object : Alphabetik.SectionIndexClickListener{
            override fun onItemClick(view: View, position: Int, character: String) {
                val scrollIndex = getPositionFromData(character)
                val scrollToPosition = mPatientAdapter?.getAdapterPositionForSectionHeader(scrollIndex)
                mFragmentPatientBinding!!.recyclerView.scrollToPosition(scrollToPosition!!)
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