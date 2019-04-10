
package com.linderaredux.api.response.patient;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Patient implements Parcelable {

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("age")
    @Expose
    public Integer age;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("weight")
    @Expose
    public Integer weight;
    @SerializedName("hasDementia")
    @Expose
    public Boolean hasDementia;
    @SerializedName("residential_form")
    @Expose
    public String residentialForm;
    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("sex")
    @Expose
    public String sex;
    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("analyse")
    @Expose
    public List<Analyse> analyse = null;
    @SerializedName("answerquestionaire")
    @Expose
    public List<Answerquestionaire> answerquestionaire = null;
    @SerializedName("answerquestionnaire")
    @Expose
    public List<Answerquestionnaire> answerquestionnaire = null;
    @SerializedName("video")
    @Expose
    public List<Video> video = null;
    public final static Creator<Patient> CREATOR = new Creator<Patient>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        public Patient[] newArray(int size) {
            return (new Patient[size]);
        }

    };

    protected Patient(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.weight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasDementia = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.residentialForm = ((String) in.readValue((String.class.getClassLoader())));
        this.firstname = ((String) in.readValue((String.class.getClassLoader())));
        this.lastname = ((String) in.readValue((String.class.getClassLoader())));
        this.sex = ((String) in.readValue((String.class.getClassLoader())));
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.analyse, (Analyse.class.getClassLoader()));
        in.readList(this.answerquestionaire, (Answerquestionaire.class.getClassLoader()));
        in.readList(this.answerquestionnaire, (Answerquestionnaire.class.getClassLoader()));
        in.readList(this.video, (Video.class.getClassLoader()));
    }

    public Patient() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(age);
        dest.writeValue(height);
        dest.writeValue(weight);
        dest.writeValue(hasDementia);
        dest.writeValue(residentialForm);
        dest.writeValue(firstname);
        dest.writeValue(lastname);
        dest.writeValue(sex);
        dest.writeValue(userID);
        dest.writeList(analyse);
        dest.writeList(answerquestionaire);
        dest.writeList(answerquestionnaire);
        dest.writeList(video);
    }

    public int describeContents() {
        return 0;
    }

}
