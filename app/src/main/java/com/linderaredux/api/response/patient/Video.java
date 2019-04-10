
package com.linderaredux.api.response.patient;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video implements Parcelable
{

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("stage")
    @Expose
    public String stage;
    @SerializedName("deleteAt")
    @Expose
    public Object deleteAt;
    @SerializedName("type")
    @Expose
    public String type;
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
    @SerializedName("localFilePath")
    @Expose
    public String localFilePath;
    @SerializedName("pathOBS")
    @Expose
    public String pathOBS;
    public final static Creator<Video> CREATOR = new Creator<Video>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        public Video[] newArray(int size) {
            return (new Video[size]);
        }

    }
    ;

    protected Video(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.stage = ((String) in.readValue((String.class.getClassLoader())));
        this.deleteAt = ((Object) in.readValue((Object.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.patientID = ((String) in.readValue((String.class.getClassLoader())));
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.localFilePath = ((String) in.readValue((String.class.getClassLoader())));
        this.pathOBS = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Video() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(stage);
        dest.writeValue(deleteAt);
        dest.writeValue(type);
        dest.writeValue(patientID);
        dest.writeValue(userID);
        dest.writeValue(timestamp);
        dest.writeValue(v);
        dest.writeValue(localFilePath);
        dest.writeValue(pathOBS);
    }

    public int describeContents() {
        return  0;
    }

}
