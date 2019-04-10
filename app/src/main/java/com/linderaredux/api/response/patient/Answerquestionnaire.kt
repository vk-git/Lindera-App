package com.linderaredux.api.response.patient

import com.google.gson.annotations.SerializedName

data class Answerquestionnaire(@SerializedName("patientID")
                                   val patientID: String,
                               @SerializedName("__v")
                                   val V: Int,
                               @SerializedName("questionnaireID")
                                   val questionnaireID: String,
                               @SerializedName("_id")
                                   val Id: String,
                               @SerializedName("userID")
                                   val userID: String,
                               @SerializedName("timestamp")
                                   val timestamp: String)