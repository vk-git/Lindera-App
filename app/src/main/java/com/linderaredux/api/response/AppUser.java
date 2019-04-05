package com.linderaredux.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppUser implements Parcelable {

    @SerializedName("OrganisationMemberShip")
    @Expose
    public OrganisationMemberShip organisationMemberShip;
    @SerializedName("homeMemberShip")
    @Expose
    public HomeMemberShip homeMemberShip;
    @SerializedName("companyMemberShip")
    @Expose
    public CompanyMemberShip companyMemberShip;
    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("deleteAt")
    @Expose
    public Object deleteAt;
    @SerializedName("userrole")
    @Expose
    public String userrole;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("__v")
    @Expose
    public Integer v;
    @SerializedName("secretTokenPw")
    @Expose
    public String secretTokenPw;
    public final static Parcelable.Creator<AppUser> CREATOR = new Creator<AppUser>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AppUser createFromParcel(Parcel in) {
            return new AppUser(in);
        }

        public AppUser[] newArray(int size) {
            return (new AppUser[size]);
        }

    };

    protected AppUser(Parcel in) {
        this.organisationMemberShip = ((OrganisationMemberShip) in.readValue((OrganisationMemberShip.class.getClassLoader())));
        this.homeMemberShip = ((HomeMemberShip) in.readValue((HomeMemberShip.class.getClassLoader())));
        this.companyMemberShip = ((CompanyMemberShip) in.readValue((CompanyMemberShip.class.getClassLoader())));
        this.firstname = ((String) in.readValue((String.class.getClassLoader())));
        this.lastname = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.deleteAt = ((Object) in.readValue((Object.class.getClassLoader())));
        this.userrole = ((String) in.readValue((String.class.getClassLoader())));
        this.role = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.secretTokenPw = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AppUser() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(organisationMemberShip);
        dest.writeValue(homeMemberShip);
        dest.writeValue(companyMemberShip);
        dest.writeValue(firstname);
        dest.writeValue(lastname);
        dest.writeValue(language);
        dest.writeValue(phone);
        dest.writeValue(status);
        dest.writeValue(deleteAt);
        dest.writeValue(userrole);
        dest.writeValue(role);
        dest.writeValue(id);
        dest.writeValue(email);
        dest.writeValue(username);
        dest.writeValue(timestamp);
        dest.writeValue(v);
        dest.writeValue(secretTokenPw);
    }

    public int describeContents() {
        return 0;
    }

}