package com.linderaredux.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyMemberShip implements Parcelable {

    @SerializedName("pending")
    @Expose
    public Boolean pending;
    public final static Parcelable.Creator<CompanyMemberShip> CREATOR = new Creator<CompanyMemberShip>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CompanyMemberShip createFromParcel(Parcel in) {
            return new CompanyMemberShip(in);
        }

        public CompanyMemberShip[] newArray(int size) {
            return (new CompanyMemberShip[size]);
        }

    };

    protected CompanyMemberShip(Parcel in) {
        this.pending = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public CompanyMemberShip() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pending);
    }

    public int describeContents() {
        return 0;
    }

}