package com.linderaredux.api.response.patient

import com.google.gson.annotations.SerializedName

data class Patient(@SerializedName("firstname")
                   val firstname: String,
                   @SerializedName("sex")
                   val sex: String,
                   @SerializedName("analyse")
                   val analyse: List<Analyse>,
                   @SerializedName("weight")
                   val weight: Int,
                   @SerializedName("video")
                   val video: List<Video>,
                   @SerializedName("userID")
                   val userID: String,
                   @SerializedName("lastname")
                   val lastname: String,
                   @SerializedName("hasDementia")
                   val hasDementia: Boolean = false,
                   @SerializedName("answerquestionnaire")
                   val answerquestionnaire: List<Answerquestionnaire>,
                   @SerializedName("answerquestionaire")
                   val answerquestionaire: List<Answerquestionaire>,
                   @SerializedName("_id")
                   val Id: String,
                   @SerializedName("residential_form")
                   val residentialForm: String,
                   @SerializedName("age")
                   val age: Int = 0,
                   @SerializedName("height")
                   val height: Int = 0)