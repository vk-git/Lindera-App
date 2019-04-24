package com.linderaredux.api.response.patient

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "patient")
data class Patient(@PrimaryKey(autoGenerate = true)
                   private var pid: Int = 0,
                   @SerializedName("firstname")
                   val firstname: String?,
                   @SerializedName("sex")
                   val sex: String?,
                   @SerializedName("analyse")
                   val analyse: List<Analyse>?,
                   @SerializedName("weight")
                   val weight: Int,
                   @SerializedName("video")
                   val video: List<Video>?,
                   @SerializedName("userID")
                   val userID: String?,
                   @SerializedName("lastname")
                   val lastname: String?,
                   @SerializedName("hasDementia")
                   val hasDementia: Boolean = false,
                   @SerializedName("answerquestionnaire")
                   val answerquestionnaire: List<Answerquestionnaire>?,
                   @SerializedName("answerquestionaire")
                   val answerquestionaire: List<Answerquestionaire>?,
                   @SerializedName("_id")
                   val Id: String?,
                   @SerializedName("residential_form")
                   val residentialForm: String?,
                   @SerializedName("age")
                   val age: Int = 0,
                   @SerializedName("height")
                   val height: Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Analyse),
            parcel.readInt(),
            parcel.createTypedArrayList(Video),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.createTypedArrayList(Answerquestionnaire),
            parcel.createTypedArrayList(Answerquestionaire),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(pid)
        parcel.writeString(firstname)
        parcel.writeString(sex)
        parcel.writeTypedList(analyse)
        parcel.writeInt(weight)
        parcel.writeTypedList(video)
        parcel.writeString(userID)
        parcel.writeString(lastname)
        parcel.writeByte(if (hasDementia) 1 else 0)
        parcel.writeTypedList(answerquestionnaire)
        parcel.writeTypedList(answerquestionaire)
        parcel.writeString(Id)
        parcel.writeString(residentialForm)
        parcel.writeInt(age)
        parcel.writeInt(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Patient> {
        override fun createFromParcel(parcel: Parcel): Patient {
            return Patient(parcel)
        }

        override fun newArray(size: Int): Array<Patient?> {
            return arrayOfNulls(size)
        }
    }
}