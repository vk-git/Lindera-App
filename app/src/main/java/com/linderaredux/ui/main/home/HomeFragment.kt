package com.linderaredux.ui.main.home

import android.os.Bundle
import android.view.View
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
import com.linderaredux.ui.main.MainActivity
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), HomeNavigator {

    companion object {
        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    var mViewModelFactory: ViewModelProvider.Factory? = null

    @set:Inject
    var mAnalysisBoxAdapter: AnalysisBoxAdapter? = null

    private var mFragmentHomeBinding: FragmentHomeBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: HomeViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(HomeViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentHomeBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("Dashboard")

        mFragmentHomeBinding!!.dashboardRV.layoutManager = LinearLayoutManager(activity)
        mFragmentHomeBinding!!.dashboardRV.adapter = mAnalysisBoxAdapter

        setDashBoardData()
    }

    fun setDashBoardData() {
        val userHomeData = viewModel.getSession().getAppUserHome()
        if (userHomeData != null)
            mFragmentHomeBinding!!.txtCompanyName.text = userHomeData.name

        val patientArchiveList = viewModel.getSession().getArchiveList()
        val patientProgressList = viewModel.getSession().getProgressList()

        if (patientProgressList != null)
            mFragmentHomeBinding!!.txtAnalysisProgress.text = "${patientProgressList.size}"

        patientArchiveList?.let {
            mFragmentHomeBinding!!.txtAnalysisComplete.text = "${it.size}"
            mAnalysisBoxAdapter!!.patientType = PatientType.ARCHIVE
            mAnalysisBoxAdapter!!.setAnalysisData(it)
        }
    }
}