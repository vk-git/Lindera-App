package com.linderaredux.ui.main.home

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
import com.linderaredux.ui.choose_patient.ChoosePatientActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.main.more.MoreViewModel
import com.linderaredux.ui.terms_of_use.TermsOfUseActivity
import com.linderaredux.utils.ViewModelProviderFactory
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
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: HomeViewModel
        get() = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)

    @set:Inject
    var mAnalysisBoxAdapter: AnalysisBoxAdapter? = null

    private var mFragmentHomeBinding: FragmentHomeBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentHomeBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("Dashboard")
        (activity as MainActivity).showToolbarRightText(true)
        (activity as MainActivity).updateToolbarRightButtonText("Start Tour")
        (activity as MainActivity).loadHomeData()
        (activity as MainActivity).loadPatientsData()
        (activity as MainActivity).setRightButtonListener(listener = View.OnClickListener {
            Toast.makeText(activity, "StartTour", Toast.LENGTH_SHORT).show()
        })

        mFragmentHomeBinding!!.dashboardRV.layoutManager = LinearLayoutManager(activity)
        mFragmentHomeBinding!!.dashboardRV.adapter = mAnalysisBoxAdapter

        mFragmentHomeBinding!!.btnStartAnalysis.setOnClickListener {
            val intent = activity?.let { ChoosePatientActivity.newIntent(it) }
            startActivity(intent)
        }

        mFragmentHomeBinding!!.btnAnalysisCompleted.setOnClickListener {
            (activity as MainActivity).onGoToAnalysisScreen(PatientType.UPLOAD)
        }

        mFragmentHomeBinding!!.btnAnalysisProgress.setOnClickListener {
            (activity as MainActivity).onGoToAnalysisScreen(PatientType.PROGRESS)
        }

        setDashBoardData()
    }

    fun setDashBoardData() {
        val userHomeData = viewModel.getSession().getAppUserHome()
        userHomeData?.let {
            mFragmentHomeBinding!!.txtCompanyName.text = it.name
        }

        val patientArchiveList = viewModel.getSession().getArchiveList()
        val patientProgressList = viewModel.getSession().getProgressList()

        patientProgressList?.let {
            mFragmentHomeBinding!!.txtAnalysisProgress.text = "${it.size}"
        }

        patientArchiveList?.let {
            mFragmentHomeBinding!!.txtAnalysisComplete.text = "${it.size}"
            mAnalysisBoxAdapter!!.patientType = PatientType.ARCHIVE
            mAnalysisBoxAdapter!!.setAnalysisData(it)
        }
    }
}