package com.linderaredux.ui.main.analyse.upload

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
import com.linderaredux.databinding.FragmentHomeBinding
import com.linderaredux.databinding.FragmentUploadBinding
import com.linderaredux.ui.main.MainActivity
import javax.inject.Inject

class UploadFragment : BaseFragment<FragmentUploadBinding, UploadViewModel>(), UploadNavigator {

    companion object {
        fun newInstance(): UploadFragment {
            val args = Bundle()
            val fragment = UploadFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    var mViewModelFactory: ViewModelProvider.Factory? = null

    @set:Inject
    var mAnalysisBoxAdapter: AnalysisBoxAdapter? = null

    private var mFragmentUploadBinding: FragmentUploadBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_upload

    override val viewModel: UploadViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(UploadViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentUploadBinding = viewDataBinding

        mFragmentUploadBinding!!.uploadingRV.layoutManager = LinearLayoutManager(activity)
        mFragmentUploadBinding!!.uploadingRV.adapter = mAnalysisBoxAdapter

        setDashBoardData()
    }

    private fun setDashBoardData() {
        val patientArchiveList = viewModel.getSession().getArchiveList()
        patientArchiveList?.let {
            mAnalysisBoxAdapter!!.patientType = PatientType.UPLOAD
            mAnalysisBoxAdapter!!.setAnalysisData(it)
        }
    }
}