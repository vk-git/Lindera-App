package com.linderaredux.ui.main.analyse

import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.AnalysisAdapter
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentAnalyseBinding
import com.linderaredux.ui.main.MainActivity
import javax.inject.Inject

class AnalyseFragment : BaseFragment<FragmentAnalyseBinding, AnalyseViewModel>(), AnalyseNavigator {

    companion object {
        fun newInstance(): AnalyseFragment {
            val args = Bundle()
            val fragment = AnalyseFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    var mViewModelFactory: ViewModelProvider.Factory? = null

    @set:Inject
    var mAnalysisAdapter: AnalysisAdapter? = null

    private var mFragmentAnalyseBinding: FragmentAnalyseBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_analyse

    override val viewModel: AnalyseViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(AnalyseViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentAnalyseBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("Analyse")

        initTabs()
    }

    private fun initTabs() {
        mFragmentAnalyseBinding!!.tabLayout.addTab(mFragmentAnalyseBinding!!.tabLayout.newTab().setText("In Progress"))
        mFragmentAnalyseBinding!!.tabLayout.addTab(mFragmentAnalyseBinding!!.tabLayout.newTab().setText("Upload"))
        mFragmentAnalyseBinding!!.tabLayout.addTab(mFragmentAnalyseBinding!!.tabLayout.newTab().setText("Archive"))
        mFragmentAnalyseBinding!!.tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        mFragmentAnalyseBinding!!.viewPager.adapter = mAnalysisAdapter
        mFragmentAnalyseBinding!!.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mFragmentAnalyseBinding!!.tabLayout))
        mFragmentAnalyseBinding!!.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                mFragmentAnalyseBinding!!.viewPager.setCurrentItem(p0!!.position, true);
            }
        })
    }
}