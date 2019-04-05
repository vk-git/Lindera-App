package com.linderaredux.utils

import com.linderaredux.api.response.patient.Patient
import java.util.*

object Sort {

    fun onPatientList(list: List<Patient>) {
        Collections.sort(list, object : Comparator<Patient> {
            override fun compare(o1: Patient?, o2: Patient?): Int {
                val genreA = o1!!.lastname.toUpperCase()
                val genreB = o2!!.lastname.toUpperCase()

                var comparison = 0
                if (genreA > genreB) {
                    comparison = 1
                } else if (genreA < genreB) {
                    comparison = -1
                }
                return comparison
            }
        })
    }
}