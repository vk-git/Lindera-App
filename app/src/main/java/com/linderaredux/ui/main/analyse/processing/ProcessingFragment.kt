package com.linderaredux.ui.main.analyse.processing

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.AnalysisBoxAdapter
import com.linderaredux.api.response.PatientType
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentProcessingBinding
import javax.inject.Inject

class ProcessingFragment : BaseFragment<FragmentProcessingBinding, ProcessingViewModel>(), ProcessingNavigator {

    companion object {
        fun newInstance(): ProcessingFragment {
            val args = Bundle()
            val fragment = ProcessingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    var mViewModelFactory: ViewModelProvider.Factory? = null

    @set:Inject
    var mAnalysisBoxAdapter: AnalysisBoxAdapter? = null

    private var mFragmentProcessingBinding: FragmentProcessingBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_processing

    override val viewModel: ProcessingViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(ProcessingViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentProcessingBinding = viewDataBinding

        mFragmentProcessingBinding!!.progressRV.layoutManager = LinearLayoutManager(activity)
        mFragmentProcessingBinding!!.progressRV.adapter = mAnalysisBoxAdapter

        setDashBoardData()
    }

    private fun setDashBoardData() {
        val patientProgressList = viewModel.getSession().getProgressList()
        patientProgressList?.let {
            mAnalysisBoxAdapter!!.patientType = PatientType.PROGRESS
            mAnalysisBoxAdapter!!.setAnalysisData(it)
        }
    }
}