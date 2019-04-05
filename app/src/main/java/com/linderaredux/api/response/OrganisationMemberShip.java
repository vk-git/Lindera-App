package com.linderaredux.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrganisationMemberShip implements Parcelable {

    @SerializedName("pending")
    @Expose
    public Boolean pending;
    public final static Parcelable.Creator<OrganisationMemberShip> CREATOR = new Creator<OrganisationMemberShip>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrganisationMemberShip createFromParcel(Parcel in) {
            return new OrganisationMemberShip(in);
        }

        public OrganisationMemberShip[] newArray(int size) {
            return (new OrganisationMemberShip[size]);
        }

    };

    protected OrganisationMemberShip(Parcel in) {
        this.pending = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public OrganisationMemberShip() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pending);
    }

    public int describeContents() {
        return 0;
    }

}