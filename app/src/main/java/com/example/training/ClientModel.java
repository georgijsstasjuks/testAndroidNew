package com.example.training;

import android.os.Parcel;
import android.os.Parcelable;

public class ClientModel implements Parcelable {

    private Integer mUserId;
    private String mUserName;
    private String mFirstName;
    private String mLastName;
    private String mCountry;
    private String mDescription;

    protected ClientModel(Parcel in) {
        if (in.readByte() == 0) {
            mUserId = null;
        } else {
            mUserId = in.readInt();
        }
        mUserName = in.readString();
        mFirstName = in.readString();
        mLastName = in.readString();
        mCountry = in.readString();
        mDescription = in.readString();
    }

    public ClientModel(int id, String username,String firstname, String lastname, String country, String description){
        mUserId = id;
        mUserName = username;
        mFirstName = firstname;
        mLastName = lastname;
        mCountry = country;
        mDescription = description;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mUserId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mUserId);
        }
        dest.writeString(mUserName);
        dest.writeString(mFirstName);
        dest.writeString(mLastName);
        dest.writeString(mCountry);
        dest.writeString(mDescription);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClientModel> CREATOR = new Creator<ClientModel>() {
        @Override
        public ClientModel createFromParcel(Parcel in) {
            return new ClientModel(in);
        }

        @Override
        public ClientModel[] newArray(int size) {
            return new ClientModel[size];
        }
    };

    public void setUserId(int id){
        this.mUserId = id;
    }

    public void setUserName(String userName){
        this.mUserName = userName;
    }

    public void setFirstName(String firstName){
        this.mFirstName = firstName;
    }

    public void setLastName(String lastName){
        this.mLastName = lastName;
    }

    public void setCountry(String country){
        this.mCountry = country;
    }

    public void setDescription(String description ){
        this.mDescription = description;
    }

    public int getUserId(){
        return mUserId;
    }

    public String getUserName(){
        return mUserName;
    }

    public String getFirstName(){
        return mFirstName;
    }

    public String getLastName(){
        return mLastName;
    }

    public String getCountry(){
        return mCountry;
    }

    public String getDescription(){
        return mDescription;
    }

}