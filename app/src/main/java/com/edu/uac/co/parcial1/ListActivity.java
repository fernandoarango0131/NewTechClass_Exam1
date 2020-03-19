package com.edu.uac.co.parcial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView contactLst;
    MyContacts myContacts;
    ContactAdapter adapter;
    ArrayList contacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        contactLst = findViewById(R.id.contactList);

        myContacts = ((MyApplication) this.getApplication()).getMyContacts();

        adapter = new ContactAdapter(ListActivity.this, myContacts.contactList);

        contactLst.setAdapter(adapter);

        Intent i = getIntent();
        Contact c = i.getParcelableExtra("contact");

        myContacts.getContactList().add(c);

        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_toolbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.searchIcon:
                Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.addContact:
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
