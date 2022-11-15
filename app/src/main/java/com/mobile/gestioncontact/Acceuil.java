package com.mobile.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class Acceuil extends AppCompatActivity {

    //Declaration
    Button btn_ajout,btn_contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);


        //Récupération des composantes
        btn_ajout = findViewById(R.id.btn_ajout_accueil);
        btn_contacts = findViewById(R.id.btn_contacts_accueil);

        //Evénement
        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Acceuil.this, Contacts.class);
                startActivity(i);
                finish();
            }
        });

        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i = new Intent(Acceuil.this, Ajout.class);
                    startActivity(i);
                    finish();
            }
        });

    }
}