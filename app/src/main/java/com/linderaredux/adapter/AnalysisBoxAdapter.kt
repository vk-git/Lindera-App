package com.linderaredux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.linderaredux.R
import com.linderaredux.api.response.PatientType
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.databinding.AnalysisboxListItemBinding
import org.zakariya.stickyheaders.SectioningAdapter

class AnalysisBoxAdapter(var context: Context) : RecyclerView.Adapter<AnalysisBoxAdapter.ViewHolder>() {

    var patientType: PatientType = PatientType.ARCHIVE
    var patientList: ArrayList<Patient> = ArrayList()

    fun setAnalysisData(patientList: ArrayList<Patient>) {
        this.patientList = patientList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val analysisboxListItemBinding = DataBindingUtil.inflate<AnalysisboxListItemBinding>(LayoutInflater.from(parent!!.context), R.layout.analysisbox_list_item, parent, false)
        return ViewHolder(analysisboxListItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val patient = patientList[position]
        holder.bind(patient)
    }

    override fun getItemCount(): Int {
        return patientList.size
    }

    inner class ViewHolder internal constructor(private val analysisboxListItemBinding: AnalysisboxListItemBinding) : SectioningAdapter.ItemViewHolder(analysisboxListItemBinding.root) {

        fun bind(patient: Patient) {
            analysisboxListItemBinding.patient = patient
            analysisboxListItemBinding.patientAnalysisBox.setPatient(patientType, patient)
            analysisboxListItemBinding.executePendingBindings()
        }
    }
}