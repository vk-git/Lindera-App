package com.linderaredux.utils

import com.linderaredux.adapter.patient.PatientSection
import com.linderaredux.api.response.patient.Patient
import java.util.*


object Sort {

    fun onPatientList(list: List<Patient>) {
        Collections.sort(list) { o1, o2 ->
            val a1 = o1.lastname.toUpperCase()
            val b1 = o2.lastname.toUpperCase()
            val c1 = o1.firstname.toUpperCase()
            val d1 = o2.firstname.toUpperCase()

            if (c1.matches("\\d+".toRegex()) && d1.matches("\\d+".toRegex())) {
                val a = c1.toInt()
                val b = d1.toInt()
                if (a < b) -1
                if (a > b) 1
                0
            }

            if (a1 > b1) {
                1
            } else if (a1 < b1) {
                -1
            }
            0
        }
    }

    fun onPatientListWithAlphabeticalSection(list: List<Patient>): ArrayList<PatientSection> {
        val patientSections = ArrayList<PatientSection>()
        val patientByAlpha = HashMap<String, ArrayList<Patient>>()
        for (patient in list) {
            val key = patient.firstname!![0].toUpperCase().toString()
            if (patientByAlpha[key] == null) {
                patientByAlpha[key] = ArrayList()
            }
            patientByAlpha[key]!!.add(patient)
        }

        for (key in patientByAlpha.keys) {
            patientSections.add(PatientSection(key, patientByAlpha[key]!!))
        }
        return patientSections
    }
}