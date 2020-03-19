package com.edu.uac.co.parcial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText name, phone;
    CheckBox familyCb, workCb, friendCb, ocationalCb;
    Button saveBtn, cancelBtn;
    String newGroup;
    Contact c;
    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameText);
        phone = findViewById(R.id.phoneText);
        familyCb = findViewById(R.id.familyCheck);
        workCb = findViewById(R.id.workCheck);
        friendCb = findViewById(R.id.friendCheck);
        ocationalCb = findViewById(R.id.ocationalCheck);
        saveBtn = findViewById(R.id.saveButton);
        cancelBtn = findViewById(R.id.cancelButton);
        registerForContextMenu(name);
        registerForContextMenu(phone);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( TextUtils.isEmpty(name.getText())) {

                    name.setError("El campo nombre es requerido!");

                } else if (TextUtils.isEmpty(phone.getText())) {

                    phone.setError("El campo telefono es requerido!");

                } else if ((familyCb.isChecked() == false) && (workCb.isChecked() == false) && (friendCb.isChecked() == false) && (ocationalCb.isChecked() == false)){

                    familyCb.setError("");

                    workCb.setError("");

                    friendCb.setError("");

                    ocationalCb.setError("");


                } else {

                    guardar();

                    Intent i = new Intent(v.getContext(), ListActivity.class);
                    i.putExtra("contact", c);
                    startActivity(i);

                    clearAll();

                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()){
            case R.id.nameText:
                getMenuInflater().inflate(R.menu.main_context_menu, menu);
                break;
            case R.id.phoneText:
                getMenuInflater().inflate(R.menu.phone_context_menu, menu);
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.cmUpperCase:
                converToUpperCase();
                Toast.makeText(this, "Nmbre en Mayúsculas", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cmRndNumber:
                generateRndPhone();
                Toast.makeText(this, "Número Aleatorio Generado", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.clearAll:
                clearAll();
                Toast.makeText(this, "Limpiar Datos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.showContactList:
                Toast.makeText(this, "Lista de Contactos", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void selectItem(View v) {
        boolean checked = ((CheckBox) v).isChecked();

        switch (v.getId()){
            case R.id.familyCheck:
                if(checked){
                    newGroup = "Familia";
                }
                break;

            case R.id.workCheck:
                if(checked){
                    newGroup = "Trabajo";
                }
                break;

            case R.id.friendCheck:
                if(checked){
                    newGroup = "Amigo";
                }
                break;

            case R.id.ocationalCheck:
                if(checked){
                    newGroup = "Ocacional";
                }
                break;
        }
    }

    public void guardar(){
        c = new Contact(name.getText().toString(), phone.getText().toString(), newGroup);
        Toast.makeText(this, "Contacto Guardado", Toast.LENGTH_SHORT).show();
    }

    public void clearAll() {
        name.setText("");
        name.setHint("Escribe algo aquí..");
        phone.setText("");
        phone.setHint("Escribe algo aquí..");
        familyCb.setChecked(false);
        workCb.setChecked(false);
        friendCb.setChecked(false);
        ocationalCb.setChecked(false);
    }

    public void converToUpperCase(){
        String str = name.getText().toString();
        name.setText(str.toUpperCase());

    }

    public void generateRndPhone(){
        int rndPre, set1, set2;

        Random rnd = new Random();

        rndPre = rnd.nextInt(3);


        set1 = rnd.nextInt(899)+ 100;

        set2 = rnd.nextInt(8999)+ 1000;

        String rndNum = ("3" + rndPre + "0" + set1 + set2);

        phone.setText(rndNum);

    }


}
