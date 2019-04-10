package com.linderaredux.utils

import com.linderaredux.adapter.patient.PatientSection
import com.linderaredux.api.response.patient.Patient
import java.util.*


object Sort {

    fun onPatientList(list: List<Patient>) {
        Collections.sort(list, object : Comparator<Patient> {
            override fun compare(o1: Patient?, o2: Patient?): Int {
                val genreA = o2!!.lastname.toUpperCase()
                val genreB = o1!!.lastname.toUpperCase()

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

    fun onPatientListWithAlphabeticalSection(list: List<Patient>): ArrayList<PatientSection> {
        val patientSections = ArrayList<PatientSection>()
        val patientByAlpha = HashMap<String, ArrayList<Patient>>()
        for (patient in list) {
            val key = patient.firstname[0].toUpperCase().toString()
            if (patientByAlpha[key] == null) {
                patientByAlpha[key] = ArrayList<Patient>()
            }
            patientByAlpha[key]!!.add(patient)
        }

        for (key in patientByAlpha.keys) {
            patientSections.add(PatientSection(key, patientByAlpha[key]!!))
        }
        return patientSections
    }
}