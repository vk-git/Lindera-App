package com.linderaredux.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.api.response.PatientType
import com.linderaredux.base.BaseActivity
import com.linderaredux.base.BaseFragment
import com.linderaredux.databinding.ActivityMainBinding
import com.linderaredux.ui.login.LoginViewModel
import com.linderaredux.ui.main.analyse.AnalyseFragment
import com.linderaredux.ui.main.home.HomeFragment
import com.linderaredux.ui.main.more.MoreFragment
import com.linderaredux.ui.main.patient.PatientFragment
import com.linderaredux.utils.FragNavController
import com.linderaredux.utils.FragNavTransactionOptions
import com.linderaredux.utils.FragmentHistory
import com.linderaredux.utils.ViewModelProviderFactory
import com.linderaredux.view.TabItem
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator, HasSupportFragmentInjector,
        BaseFragment.FragmentNavigation,
        FragNavController.TransactionListener, FragNavController.RootFragmentListener {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    @set:Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: MainViewModel
        get() = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

    private var mActivityMainBinding: ActivityMainBinding? = null

    private var mNavController: FragNavController? = null

    private var fragmentHistory: FragmentHistory? = null

    private var tabs: Array<String>? = null

    private val mTabIconsSelected = intArrayOf(
            R.drawable.dashboard_off,
            R.drawable.patient_off,
            R.drawable.analyse_off,
            R.drawable.more_off
    )

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        tabs = resources.getStringArray(R.array.tab_name)

        fragmentHistory = FragmentHistory()

        supportFragmentManager?.run {
            mNavController = FragNavController.newBuilder(savedInstanceState, this, R.id.container)
                    .transactionListener(this@MainActivity)
                    .rootFragmentListener(this@MainActivity, (tabs as Array<String>).size)
                    .build()
        }

        initTab()

        mActivityMainBinding?.run {
            bottomTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    fragmentHistory?.push(tab.position)
                    switchTab(tab.position)
                    updateTabSelection(tab.position)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    updateTabSelection(tab.position)
                }

                override fun onTabReselected(tab: TabLayout.Tab) {
                    mNavController?.clearStack()
                    fragmentHistory?.push(tab.position)
                    switchTab(tab.position)
                    updateTabSelection(tab.position)
                }
            })
        }

        switchTab(0)
        setTabViewSelectedColor(bottomTabLayout.getTabAt(0)!!)
    }

    fun loadHomeData() {
        viewModel?.run {
            userHome()
        }
    }

    fun loadPatientsData() {
        viewModel?.run {
            userPatients()
        }
    }

    override fun onHomeDataUpdate() {
        val currentFrag = mNavController!!.currentFrag
        if (currentFrag is HomeFragment) {
            currentFrag.setDashBoardData()
        }
    }

    override fun onPatientDataUpdate() {
        val currentFrag = mNavController!!.currentFrag
        if (currentFrag is HomeFragment) {
            currentFrag.setDashBoardData()
        }
    }

    private fun initTab() {
        if (mActivityMainBinding!!.bottomTabLayout != null) {
            for (i in 0 until tabs!!.size) {
                mActivityMainBinding!!.bottomTabLayout.addTab(bottomTabLayout.newTab())
                val tab = mActivityMainBinding!!.bottomTabLayout.getTabAt(i)
                if (tab != null)
                    tab.customView = getTabView(i)
            }
        }
    }

    private fun setTabViewSelectedColor(tab: TabLayout.Tab) {
        val selected = tab.customView as TabItem
        selected.setSelectedTab(R.color.colorPrimary)
    }

    private fun setTabViewUnSelectedColor(tab: TabLayout.Tab) {
        val unSelected = tab.customView as TabItem
        unSelected.setSelectedTab(R.color.black)
    }

    private fun getTabView(position: Int): View {
        val tabItem = TabItem(applicationContext)
        tabItem.setTabIcon(mTabIconsSelected[position])
        return tabItem
    }

    private fun switchTab(position: Int) {
        mNavController?.run {
            switchTab(position)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onBackPressed() {
        if (!mNavController?.isRootFragment!!) {
            val customAnimation =
                    FragNavTransactionOptions.newBuilder().customAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
                            .build()
            mNavController?.popFragment(customAnimation)
        } else {
            if (fragmentHistory?.isEmpty()!!) {
                super.onBackPressed()
            } else {
                if (fragmentHistory?.getStackSize()!! > 1) {
                    val position = fragmentHistory?.popPrevious()
                    switchTab(position!!)
                    updateTabSelection(position)
                } else {
                    switchTab(0)
                    updateTabSelection(0)
                    fragmentHistory?.emptyStack()
                }
            }
        }
    }

    private fun updateTabSelection(currentTab: Int) {
        for (i in 0 until tabs?.size!!) {
            if (currentTab == i) {
                setTabViewSelectedColor(mActivityMainBinding!!.bottomTabLayout.getTabAt(i)!!)
            } else {
                setTabViewUnSelectedColor(mActivityMainBinding!!.bottomTabLayout.getTabAt(i)!!)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mNavController?.run { onSaveInstanceState(outState) }
    }

    override fun pushFragment(fragment: Fragment) {
        val customAnimation = FragNavTransactionOptions.newBuilder().customAnimations(R.anim.enter_from_right, R.anim.exit_to_left).build()
        mNavController?.run { pushFragment(fragment, customAnimation) }
    }

    override fun onTabTransaction(fragment: Fragment, index: Int) {
        if (navToolbar != null && mNavController != null) {
            updateToolbar()
        }
    }

    override fun onFragmentTransaction(fragment: Fragment, transactionType: FragNavController.TransactionType) {
        if (navToolbar != null && mNavController != null) {
            updateToolbar()
        }
    }

    override fun getRootFragment(index: Int): Fragment {
        when (index) {
            FragNavController.TAB1 -> return HomeFragment.newInstance()
            FragNavController.TAB2 -> return PatientFragment.newInstance()
            FragNavController.TAB3 -> return AnalyseFragment.newInstance()
            FragNavController.TAB4 -> return MoreFragment.newInstance()
        }
        throw IllegalStateException("Need to send an index that we know")
    }

    fun updateToolbarTitle(title: String) {
        mActivityMainBinding!!.navToolbar.setToolbarTitle(title)
    }

    private fun updateToolbar() {
        if (!mNavController?.isRootFragment!!) {
            mActivityMainBinding!!.navToolbar.setBackButton(true)
            mActivityMainBinding!!.navToolbar.setBackButtonListener(listener = View.OnClickListener { onBackPressed() })
        } else {
            mActivityMainBinding!!.navToolbar.setBackButton(false)
            mActivityMainBinding!!.navToolbar.setBackButtonListener(null)
        }
    }

    fun updateToolbarRightButtonText(txtRight: String) {
        mActivityMainBinding?.run {
            navToolbar.setRightText(txtRight)
        }
    }

    fun showToolbarRightText(isShow: Boolean) {
        mActivityMainBinding?.run {
            navToolbar.showRightText(isShow)
        }
    }

    fun setRightButtonListener(listener: View.OnClickListener?) {
        mActivityMainBinding?.run {
            navToolbar.setRightButtonListener(listener)
        }
    }

    fun onGoToAnalysisScreen(patientType: PatientType) {
        fragmentHistory?.push(2)
        switchTab(2)
        updateTabSelection(2)
        mNavController?.clearStack()
        val currentFragment = mNavController?.currentFrag!!
        if (currentFragment is AnalyseFragment) {
            currentFragment.setSelectedTab(patientType)
        }
    }
}
