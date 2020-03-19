package com.edu.uac.co.parcial1;

import android.app.Application;

public class MyApplication extends Application {

    private MyContacts myContacts = new MyContacts();

    public MyContacts getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(MyContacts myContacts) {
        this.myContacts = myContacts;
    }

}
