package com.linderaredux.ui.main.analyse.archive

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentArchiveBinding
import com.linderaredux.databinding.FragmentHomeBinding
import com.linderaredux.databinding.FragmentUploadBinding
import com.linderaredux.ui.main.MainActivity
import javax.inject.Inject

class ArchiveFragment : BaseFragment<FragmentArchiveBinding, ArchiveViewModel>(), ArchiveNavigator {

    companion object {
        fun newInstance(): ArchiveFragment {
            val args = Bundle()
            val fragment = ArchiveFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    var mViewModelFactory: ViewModelProvider.Factory? = null

    private var mFragmentArchiveBinding: FragmentArchiveBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_archive

    override val viewModel: ArchiveViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(ArchiveViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentArchiveBinding = viewDataBinding
    }
}