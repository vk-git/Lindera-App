package com.linderaredux.ui.main.more

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.FragmentMoreBinding
import com.linderaredux.ui.facility.FacilityActivity
import com.linderaredux.ui.landing.LandingActivity
import com.linderaredux.ui.main.MainActivity
import com.linderaredux.ui.profile.ProfileActivity
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

    override fun onProfileScreen() {
        val intent = activity?.let { ProfileActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onFacilityScreen() {
        val intent = activity?.let { FacilityActivity.newIntent(it) }
        startActivity(intent)
    }

    override fun onLogout() {
        val intent = LandingActivity.newIntent(context!!)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}