package com.edu.uac.co.parcial1;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

public class Contact implements Parcelable {

    public String name;
    public String phone;
    public String group;

    public Contact(String name, String phone, String group) {
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        phone = in.readString();
        group = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(group);
    }
}
