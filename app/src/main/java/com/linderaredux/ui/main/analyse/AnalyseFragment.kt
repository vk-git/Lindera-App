package com.linderaredux.ui.main.analyse

import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
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
    }
}