
package com.linderaredux.api.response.patient;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Analyse implements Parcelable
{

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("videoID")
    @Expose
    public Object videoID;
    @SerializedName("patientID")
    @Expose
    public String patientID;
    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("homeID")
    @Expose
    public Object homeID;
    @SerializedName("answerQuestionnaireID")
    @Expose
    public Object answerQuestionnaireID;
    @SerializedName("params")
    @Expose
    public Object params;
    @SerializedName("submittedByUser")
    @Expose
    public Boolean submittedByUser;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("score")
    @Expose
    public Object score;
    @SerializedName("dispatchDate")
    @Expose
    public Object dispatchDate;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("recommendations")
    @Expose
    public List<Object> recommendations = null;
    @SerializedName("recommendationImplementation")
    @Expose
    public List<Object> recommendationImplementation = null;
    @SerializedName("sequenceNumber")
    @Expose
    public Integer sequenceNumber;
    @SerializedName("__v")
    @Expose
    public Integer v;
    @SerializedName("answerQuestionaireID")
    @Expose
    public String answerQuestionaireID;
    public final static Creator<Analyse> CREATOR = new Creator<Analyse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Analyse createFromParcel(Parcel in) {
            return new Analyse(in);
        }

        public Analyse[] newArray(int size) {
            return (new Analyse[size]);
        }

    }
    ;

    protected Analyse(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.videoID = ((Object) in.readValue((Object.class.getClassLoader())));
        this.patientID = ((String) in.readValue((String.class.getClassLoader())));
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        this.homeID = ((Object) in.readValue((Object.class.getClassLoader())));
        this.answerQuestionnaireID = ((Object) in.readValue((Object.class.getClassLoader())));
        this.params = ((Object) in.readValue((Object.class.getClassLoader())));
        this.submittedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.score = ((Object) in.readValue((Object.class.getClassLoader())));
        this.dispatchDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.recommendations, (Object.class.getClassLoader()));
        in.readList(this.recommendationImplementation, (Object.class.getClassLoader()));
        this.sequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.answerQuestionaireID = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Analyse() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(language);
        dest.writeValue(videoID);
        dest.writeValue(patientID);
        dest.writeValue(userID);
        dest.writeValue(homeID);
        dest.writeValue(answerQuestionnaireID);
        dest.writeValue(params);
        dest.writeValue(submittedByUser);
        dest.writeValue(status);
        dest.writeValue(score);
        dest.writeValue(dispatchDate);
        dest.writeValue(timestamp);
        dest.writeList(recommendations);
        dest.writeList(recommendationImplementation);
        dest.writeValue(sequenceNumber);
        dest.writeValue(v);
        dest.writeValue(answerQuestionaireID);
    }

    public int describeContents() {
        return  0;
    }

}
