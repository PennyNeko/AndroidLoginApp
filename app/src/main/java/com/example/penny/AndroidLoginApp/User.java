package com.example.penny.AndroidLoginApp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Penny on 15/11/2017.
 */

public class User implements Parcelable{
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    public User(String username, String password, String name, String email, String telephone){
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setTelephone(telephone);
    }

    public User(Parcel in){
        this.setUsername(in.readString());
        this.setPassword(in.readString());
        this.setName(in.readString());
        this.setEmail(in.readString());
        this.setTelephone(in.readString());
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(telephone);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>(){
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
