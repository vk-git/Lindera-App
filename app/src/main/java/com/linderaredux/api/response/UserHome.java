package com.linderaredux.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserHome implements Parcelable {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("countrycodeISO316a2")
    @Expose
    public String countrycodeISO316a2;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("street")
    @Expose
    public String street;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("zip")
    @Expose
    public String zip;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("__v")
    @Expose
    public Integer v;
    public final static Parcelable.Creator<UserHome> CREATOR = new Creator<UserHome>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserHome createFromParcel(Parcel in) {
            return new UserHome(in);
        }

        public UserHome[] newArray(int size) {
            return (new UserHome[size]);
        }

    };

    protected UserHome(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.countrycodeISO316a2 = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.street = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.zip = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public UserHome() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(countrycodeISO316a2);
        dest.writeValue(language);
        dest.writeValue(id);
        dest.writeValue(city);
        dest.writeValue(street);
        dest.writeValue(name);
        dest.writeValue(zip);
        dest.writeValue(timestamp);
        dest.writeValue(v);
    }

    public int describeContents() {
        return 0;
    }

}