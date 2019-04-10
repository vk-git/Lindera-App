
package com.linderaredux.api.response.patient;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answerquestionaire implements Parcelable
{

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("questionnaireID")
    @Expose
    public String questionnaireID;
    @SerializedName("patientID")
    @Expose
    public String patientID;
    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("__v")
    @Expose
    public Integer v;
    public final static Creator<Answerquestionaire> CREATOR = new Creator<Answerquestionaire>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Answerquestionaire createFromParcel(Parcel in) {
            return new Answerquestionaire(in);
        }

        public Answerquestionaire[] newArray(int size) {
            return (new Answerquestionaire[size]);
        }

    }
    ;

    protected Answerquestionaire(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.questionnaireID = ((String) in.readValue((String.class.getClassLoader())));
        this.patientID = ((String) in.readValue((String.class.getClassLoader())));
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Answerquestionaire() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(questionnaireID);
        dest.writeValue(patientID);
        dest.writeValue(userID);
        dest.writeValue(timestamp);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}
