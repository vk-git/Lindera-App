package com.linderaredux.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.linderaredux.ui.main.analyse.archive.ArchiveFragment
import com.linderaredux.ui.main.analyse.processing.ProcessingFragment
import com.linderaredux.ui.main.analyse.upload.UploadFragment

class AnalysisAdapter(fm: FragmentManager, private val totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ProcessingFragment.newInstance()
            1 -> UploadFragment.newInstance()
            2 -> ArchiveFragment.newInstance()
            else -> UploadFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
