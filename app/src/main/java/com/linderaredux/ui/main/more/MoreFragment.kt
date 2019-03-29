package com.linderaredux.ui.main.more

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentHomeBinding
import com.linderaredux.databinding.FragmentMoreBinding
import com.linderaredux.ui.main.MainActivity
import javax.inject.Inject

class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>(), MoreNavigator {

    companion object {
        fun newInstance(): MoreFragment {
            val args = Bundle()
            val fragment = MoreFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @set:Inject
    var mViewModelFactory: ViewModelProvider.Factory? = null

    private var mFragmentMoreBinding: FragmentMoreBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_more

    override val viewModel: MoreViewModel
        get() = ViewModelProviders.of(this, mViewModelFactory).get(MoreViewModel::class.java)

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentMoreBinding = viewDataBinding

        (activity as MainActivity).updateToolbarTitle("More")
    }

    override fun onInternetConnectionError() {
        Toast.makeText(
                activity,
                getString(R.string.please_check_your_internet_connection_or_try_again_later),
                Toast.LENGTH_SHORT
        ).show()
    }

    override fun handleError(error: String) {
        Toast.makeText(
                activity,
                error,
                Toast.LENGTH_SHORT
        ).show()
    }
}