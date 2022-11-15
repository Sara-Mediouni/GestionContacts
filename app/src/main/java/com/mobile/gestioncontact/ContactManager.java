package com.mobile.gestioncontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    Context con;
    SQLiteDatabase mabase;

    // Constructeur
    public ContactManager(@Nullable Context con) {
        this.con = con;
    }

    public void ouvrir() {
        ContactHelper helper=new ContactHelper(con,null,null,1);
        // declaration d'une base
        // si on modifie la version == appel implicite à onUpgrade
        mabase= helper.getWritableDatabase();
        // permet de ouvrir la base si elle existe
        // si n'existe pas, elle cree le fichier
        // et appel oncreate ==> creation des tables
    }

    public void ouvrir_read() {
        ContactHelper helper=new ContactHelper(con,null,null,1);
        // declaration d'une base
        // si on modifie la version == appel implicite à onUpgrade
        mabase= helper.getReadableDatabase();
        // permet de ouvrir la base si elle existe
        // si n'existe pas, elle cree le fichier
        // et appel oncreate ==> creation des tables
    }

    public void fermer() {
        mabase.close();
    }

    public void inserer(String nom,String prenom,String tel) {
        // insertion dans la base
        ContentValues v=new ContentValues();
        // v est un hashmap
        v.put(ContactHelper.col_nom,nom);
        v.put(ContactHelper.col_prenom,prenom);
        v.put(ContactHelper.col_tel,tel);
        mabase.insert(ContactHelper.table_contact,null,v);
    }

    List<Contact> selectionnertout() {
        // initialisation de la valeur de retour
        List<Contact> data=new ArrayList<Contact>();
        // selection depuis la base Cursor
        Cursor cr = mabase.query(ContactHelper.table_contact, new String[]{ContactHelper.col_id, ContactHelper.col_nom, ContactHelper.col_prenom, ContactHelper.col_tel}, null, null, null, null, null);
        // conversion d'un cursor à une arraylist data
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            int i1 = cr.getInt(0);
            String i2 = cr.getString(1);
            String i3 = cr.getString(2);
            String i4 = cr.getString(3);
            data.add(new Contact(i1,i2,i3,i4));
            cr.moveToNext();
        }
        System.out.println(data);
        return data;
    }

    long modifier ( int id,String nom,String prenom,String tel) {
        int a=-1;
        // initialisation nouvelle valeur
        ContentValues v=new ContentValues();
        v.put(ContactHelper.col_id,id);
        v.put(ContactHelper.col_nom,nom);
        v.put(ContactHelper.col_prenom,prenom);
        v.put(ContactHelper.col_tel,tel);
        a=mabase.update(ContactHelper.table_contact, v, ContactHelper.col_id+"="+id,null);
        return a;
    }

    long supprimer(int id) {
        int a=-1;
        a=mabase.delete(ContactHelper.table_contact, ContactHelper.col_id+"="+id,null);
        return a;
    }

}
