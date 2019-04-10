
package com.linderaredux.api.response.patient;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answerquestionnaire implements Parcelable
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
    public final static Creator<Answerquestionnaire> CREATOR = new Creator<Answerquestionnaire>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Answerquestionnaire createFromParcel(Parcel in) {
            return new Answerquestionnaire(in);
        }

        public Answerquestionnaire[] newArray(int size) {
            return (new Answerquestionnaire[size]);
        }

    }
    ;

    protected Answerquestionnaire(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.questionnaireID = ((String) in.readValue((String.class.getClassLoader())));
        this.patientID = ((String) in.readValue((String.class.getClassLoader())));
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Answerquestionnaire() {
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
