package com.mobile.gestioncontact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ajout extends AppCompatActivity {

    //Declaration
    Button btn_val,btn_ret;
    EditText ed_nom,ed_prenom,ed_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);


        //Récupération des composantes
        btn_val = findViewById(R.id.btn_val_add);
        btn_ret = findViewById(R.id.btn_ret_add);
        ed_nom = findViewById(R.id.ed_nom_add);
        ed_prenom = findViewById(R.id.ed_prenom_add);
        ed_tel = findViewById(R.id.ed_tel_add);

        //Evénement

        //Validation
        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Sauvegarde de donnée
                ContactManager cm = new ContactManager(getApplicationContext());
                cm.ouvrir();
                cm.inserer(ed_nom.getText().toString(),ed_prenom.getText().toString(),ed_tel.getText().toString());
                cm.fermer();
                //Redirection à la page d'accueil
                Intent i = new Intent(Ajout.this, Acceuil.class);
                startActivity(i);
                finish();
            }
        });

        //Retour à l'accueil
        btn_ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Retour à la page d'accueil
                Intent i = new Intent(Ajout.this, Acceuil.class);
                startActivity(i);
                finish();
            }
        });

    }
}