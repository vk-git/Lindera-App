package com.linderaredux.api.response.patient

import com.google.gson.annotations.SerializedName

data class Analyse(@SerializedName("sequenceNumber")
                       val sequenceNumber: Int = 0,
                   @SerializedName("patientID")
                       val patientID: String,
                   @SerializedName("dispatchDate")
                       val dispatchDate: String,
                   @SerializedName("language")
                       val language: String,
                   @SerializedName("videoID")
                       val videoID: String,
                   @SerializedName("params")
                       val params: String,
                   @SerializedName("userID")
                       val userID: String,
                   @SerializedName("answerQuestionaireID")
                       val answerQuestionaireID: String,
                   @SerializedName("score")
                       val score: String,
                   @SerializedName("__v")
                       val V: Int,
                   @SerializedName("answerQuestionnaireID")
                       val answerQuestionnaireID: String,
                   @SerializedName("submittedByUser")
                       val submittedByUser: Boolean = false,
                   @SerializedName("_id")
                       val Id: String,
                   @SerializedName("homeID")
                       val homeID: String,
                   @SerializedName("status")
                       val status: String,
                   @SerializedName("timestamp")
                       val timestamp: String)