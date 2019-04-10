package com.linderaredux.api.response.patient

import com.google.gson.annotations.SerializedName

data class Video(@SerializedName("stage")
                     val stage: String,
                 @SerializedName("deleteAt")
                     val deleteAt: String,
                 @SerializedName("patientID")
                     val patientID: String,
                 @SerializedName("__v")
                     val V: Int,
                 @SerializedName("pathOBS")
                     val pathOBS: String,
                 @SerializedName("_id")
                     val Id: String,
                 @SerializedName("type")
                     val type: String,
                 @SerializedName("userID")
                     val userID: String,
                 @SerializedName("localFilePath")
                     val localFilePath: String,
                 @SerializedName("timestamp")
                     val timestamp: String)