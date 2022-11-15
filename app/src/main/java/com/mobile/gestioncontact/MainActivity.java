package com.mobile.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Declaration
    Button btn_val,btn_quit;
    EditText ed_email,ed_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupération des composantes
        btn_val = findViewById(R.id.btn_val_auth);
        btn_quit = findViewById(R.id.btn_quit_auth);
        ed_email = findViewById(R.id.ed_email_auth);
        ed_pwd = findViewById(R.id.ed_password_auth);

        //Evénement
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//Fermer l'activité
            }
        });

        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Réserver les champs
                String email = ed_email.getText().toString();
                String pwd = ed_pwd.getText().toString();
                if (email.equals("azer") && pwd.equals("000")){
                    //Passage entre activité
                    Intent i = new Intent(MainActivity.this, Acceuil.class);
                    startActivity(i);
                }
                else{
                    //Message d'erreur
                    Toast.makeText(MainActivity.this, "Echec d'authentification!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}