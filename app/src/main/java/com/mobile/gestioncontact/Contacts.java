package com.mobile.gestioncontact;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout= fillContent();
        setContentView(layout);
    }


    private LinearLayout fillContent(){
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20,20,20,20);
        TextView text=new TextView(this);
        text.setText("Contacts");
        text.setTextColor(Color.RED);
        text.setTextSize(30);
        text.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        layout.addView(text);
        ContactManager cm = new ContactManager(getApplicationContext());
        cm.ouvrir_read();
        List<Contact> contactList=cm.selectionnertout();
        cm.fermer();
        contactList.stream().forEach(contact -> {
            LinearLayout contactLayout=new LinearLayout(this);
            contactLayout.setPadding(10,10,10,10);
            contactLayout.setOrientation(LinearLayout.HORIZONTAL);
            contactLayout.setPadding(10,10,10,10);
            TextView textView = new TextView(this);
            textView.setText(contact.getPrenom()+' '+contact.getNom()+"\n"+contact.getTel());
            textView.setTextColor(Color.CYAN);
            textView.setTextSize(20);
            textView.setId(contact.getId());

            Button edit = new Button(this);
            edit.setText("Edit");
            Button del = new Button(this);
            del.setText("Delete");

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Contacts.this,Edition.class);
                    i.putExtra("id",contact.getId());
                    startActivity(i);
                    finish();
                }
            });

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ContactManager cm = new ContactManager(getApplicationContext());
                    cm.ouvrir_read();
                    cm.supprimer(contact.getId());
                    cm.fermer();
                    Intent i = new Intent(Contacts.this,Contacts.class);
                    startActivity(i);
                    finish();
                }
            });
            LinearLayout contactBtnLayout=new LinearLayout(this);
            contactBtnLayout.setPadding(10,10,10,10);
            contactBtnLayout.setOrientation(LinearLayout.VERTICAL);
            contactBtnLayout.setPadding(10,10,10,10);
            contactLayout.addView(textView);
            contactBtnLayout.addView(edit);
            contactBtnLayout.addView(del);
            contactLayout.addView(contactBtnLayout);
            layout.addView(contactLayout);
        });
        return layout;
    }
}
