package com.edu.uac.co.parcial1;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private final Context context;
    private final ArrayList<Contact> contacts;


    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, -1, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_contact, parent,false);

        TextView name = (TextView) rowView.findViewById(R.id.tvName);
        TextView phone = (TextView) rowView.findViewById(R.id.tvPhone);
        TextView group = (TextView) rowView.findViewById(R.id.tvGroup);

        Contact c = this.getItem(position);

        name.setText(c.getName());
        phone.setText(c.getPhone());
        group.setText(c.getGroup());

        return rowView;

    }
}
