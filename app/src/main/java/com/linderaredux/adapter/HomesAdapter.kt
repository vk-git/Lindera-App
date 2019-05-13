package com.linderaredux.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.linderaredux.R
import com.linderaredux.api.response.UserHome
import com.linderaredux.databinding.HomeItemBinding
import org.zakariya.stickyheaders.SectioningAdapter

class HomesAdapter : RecyclerView.Adapter<HomesAdapter.ViewHolder>() {

    var homesList: ArrayList<UserHome> = ArrayList()

    fun setHomeData(homesList: ArrayList<UserHome>) {
        this.homesList = homesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val homeItemBinding = DataBindingUtil.inflate<HomeItemBinding>(LayoutInflater.from(parent.context), R.layout.home_item, parent, false)
        return ViewHolder(homeItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val patient = homesList[position]
        holder.bind(patient)
    }

    override fun getItemCount(): Int {
        return homesList.size
    }

    inner class ViewHolder internal constructor(private val homeItemBinding: HomeItemBinding) : SectioningAdapter.ItemViewHolder(homeItemBinding.root) {

        fun bind(userHome: UserHome) {
            homeItemBinding.userHome = userHome
            homeItemBinding.executePendingBindings()
        }
    }
}