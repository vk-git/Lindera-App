package com.linderaredux.ui.delete_account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityContactBinding
import com.linderaredux.databinding.ActivityDeleteAccountBinding
import com.linderaredux.ui.create_patient.CreatePatientViewModel
import com.linderaredux.utils.ViewModelProviderFactory
import javax.inject.Inject

class DeleteAccountActivity : BaseActivity<ActivityDeleteAccountBinding, DeleteAccountViewModel>(), DeleteAccountNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DeleteAccountActivity::class.java)
        }
    }

   @set:Inject
    lateinit var factory: ViewModelProviderFactory

    override val viewModel: DeleteAccountViewModel
        get() = ViewModelProviders.of(this, factory).get(DeleteAccountViewModel::class.java)

    private var mActivityDeleteAccountBinding: ActivityDeleteAccountBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_delete_account

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityDeleteAccountBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityDeleteAccountBinding!!.toolbar.setBackButton(true)
        mActivityDeleteAccountBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })
    }
}