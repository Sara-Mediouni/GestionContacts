package com.mobile.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edition extends AppCompatActivity {

    //Declaration
    Button btn_edit;
    EditText ed_nom,ed_prenom,ed_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition);

        //Récupération des composantes
        btn_edit = findViewById(R.id.btn_edit_edit);
        ed_nom = findViewById(R.id.ed_nom_edit);
        ed_prenom = findViewById(R.id.ed_prenom_edit);
        ed_tel = findViewById(R.id.ed_tel_edit);

        //Evénement

        //Validation
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Sauvegarde de donnée
                ContactManager cm = new ContactManager(getApplicationContext());
                cm.ouvrir();
                cm.modifier(getIntent().getIntExtra("id",1),ed_nom.getText().toString(),ed_prenom.getText().toString(),ed_tel.getText().toString());
                cm.fermer();
                //Redirection à la page d'accueil
                Intent i = new Intent(Edition.this, Contacts.class);
                startActivity(i);
                finish();
            }
        });
    }
}