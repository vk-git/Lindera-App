package com.linderaredux.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeMemberShip implements Parcelable {

    @SerializedName("pending")
    @Expose
    public Boolean pending;
    @SerializedName("member")
    @Expose
    public String member;
    public final static Parcelable.Creator<HomeMemberShip> CREATOR = new Creator<HomeMemberShip>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeMemberShip createFromParcel(Parcel in) {
            return new HomeMemberShip(in);
        }

        public HomeMemberShip[] newArray(int size) {
            return (new HomeMemberShip[size]);
        }

    };

    protected HomeMemberShip(Parcel in) {
        this.pending = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.member = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeMemberShip() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pending);
        dest.writeValue(member);
    }

    public int describeContents() {
        return 0;
    }

}