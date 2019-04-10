package com.linderaredux.api.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(@SerializedName("confirmation")
                           val confirmation: String,
                           @SerializedName(value = "message", alternate = ["errors"])
                           val data: T,
                           @SerializedName("token")
                           val token: String)