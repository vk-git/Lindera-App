package com.linderaredux.adapter.patient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.linderaredux.R
import com.linderaredux.api.response.patient.Patient
import com.linderaredux.databinding.PatientListItemBinding
import org.zakariya.stickyheaders.SectioningAdapter
import java.util.*

class PatientAdapter : SectioningAdapter() {

    private var patientSections: ArrayList<PatientSection>? = null
    private lateinit var onPatientItemListener: OnPatientItemListener

    fun setPatientSections(patientSections: ArrayList<PatientSection>) {
        this.patientSections = patientSections
        notifyDataSetChanged()
    }

    fun setOnPatientItemListener(onPatientItemListener: OnPatientItemListener) {
        this.onPatientItemListener = onPatientItemListener
    }

    override fun getNumberOfSections(): Int {
        return if (patientSections != null) patientSections!!.size else 0
    }

    override fun getNumberOfItemsInSection(sectionIndex: Int): Int {
        return patientSections!![sectionIndex].patientArrayList.size
    }

    override fun doesSectionHaveHeader(sectionIndex: Int): Boolean {
        return true
    }

    override fun doesSectionHaveFooter(sectionIndex: Int): Boolean {
        return false
    }

    override fun onCreateItemViewHolder(parent: ViewGroup?, itemType: Int): SectioningAdapter.ItemViewHolder {
        val patientListItemBinding = DataBindingUtil.inflate<PatientListItemBinding>(LayoutInflater.from(parent!!.context), R.layout.patient_list_item, parent, false)
        return ItemViewHolder(patientListItemBinding)
    }

    override fun onCreateGhostHeaderViewHolder(parent: ViewGroup): SectioningAdapter.GhostHeaderViewHolder {
        val ghostView = View(parent.context)
        ghostView.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return SectioningAdapter.GhostHeaderViewHolder(ghostView)
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup?, headerType: Int): SectioningAdapter.HeaderViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val v = inflater.inflate(R.layout.header_item, parent, false)
        return HeaderViewHolder(v)
    }

    override fun onBindItemViewHolder(viewHolder: SectioningAdapter.ItemViewHolder?, sectionIndex: Int, itemIndex: Int, itemType: Int) {
        val jobsSection = patientSections!![sectionIndex]
        val ivh = viewHolder as ItemViewHolder?
        val patient = jobsSection.patientArrayList[itemIndex]
        ivh!!.bind(patient)
    }

    override fun onBindHeaderViewHolder(headerViewHolder: SectioningAdapter.HeaderViewHolder?, sectionIndex: Int, headerType: Int) {
        val jobsSection = patientSections!![sectionIndex]
        val hvh = headerViewHolder as HeaderViewHolder?
        hvh!!.titleTextView.text = jobsSection.headerTitle
    }

    inner class ItemViewHolder internal constructor(private val patientListItemBinding: PatientListItemBinding) : SectioningAdapter.ItemViewHolder(patientListItemBinding.root) {

        fun bind(patient: Patient) {
            patientListItemBinding.patient = patient
            patientListItemBinding.itemView.setOnClickListener {
                if(onPatientItemListener!=null){
                    onPatientItemListener.onItemClick(patient)
                }
            }
            patientListItemBinding.executePendingBindings()
        }
    }

    inner class HeaderViewHolder internal constructor(itemView: View) : SectioningAdapter.HeaderViewHolder(itemView) {
        internal var titleTextView: TextView = itemView.findViewById(R.id.headerText)
    }

    interface OnPatientItemListener {
        fun onItemClick(patient: Patient)
    }
}