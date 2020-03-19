package com.edu.uac.co.parcial1;

import java.util.ArrayList;
import java.util.Random;

public class MyContacts {

    ArrayList<Contact> contactList;

    public MyContacts(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public MyContacts(){
        String[] startingNames = {"Adam", "Ben", "Carl"};
        String[] startingPhones = {"3005852424", "3016783434", "3117467777"};
        String[] startingGroups = {"Work", "Family", "Friend"};
        this.contactList = new ArrayList<>();

        for (int i=0; i<startingNames.length; i++){
            Contact c = new Contact(startingNames[i], startingPhones[i] , startingGroups[i]);
            contactList.add(c);
        }
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }
}
