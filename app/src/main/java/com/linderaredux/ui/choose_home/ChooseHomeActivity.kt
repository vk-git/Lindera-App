package com.linderaredux.ui.choose_home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.adapter.HomesAdapter
import com.linderaredux.api.response.UserHome
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityChooseHomeBinding
import com.linderaredux.utils.RxSearch
import com.linderaredux.utils.ViewModelProviderFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ChooseHomeActivity : BaseActivity<ActivityChooseHomeBinding, ChooseHomeViewModel>(), ChooseHomeNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ChooseHomeActivity::class.java)
        }
    }

    @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: ChooseHomeViewModel
        get() = ViewModelProviders.of(this, factory).get(ChooseHomeViewModel::class.java)

    @set:Inject
    lateinit var homesAdapter: HomesAdapter

    private var mActivityChooseHomeBinding: ActivityChooseHomeBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_choose_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityChooseHomeBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        with(mActivityChooseHomeBinding!!.toolbar) {
            setBackButton(true)
            setBackButtonListener(listener = View.OnClickListener {
                finish()
            })
        }

        with(mActivityChooseHomeBinding!!.recyclerView) {
            layoutManager = LinearLayoutManager(this@ChooseHomeActivity)
            adapter = homesAdapter
        }

        with(mActivityChooseHomeBinding!!.etSearch) {
            RxSearch.fromView(this)
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .distinctUntilChanged()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { result -> viewModel.userHomes(result) }
        }
    }

    override fun gUserHomeList(data: List<UserHome>) {
        Log.d("mytag", "Data::" + data.size)
    }
}