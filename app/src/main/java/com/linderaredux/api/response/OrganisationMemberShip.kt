package com.linderaredux.api.response

import com.google.gson.annotations.SerializedName

data class OrganisationMemberShip(@SerializedName("pending")
                                  val pending: Boolean)