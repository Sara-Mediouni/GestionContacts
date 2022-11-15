package com.mobile.gestioncontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {
    private static final int db_version=1;
    public static final String dbname="contactManagementDb";

    // declaration de nom de la table, titre des champs
    public static final String table_contact="Contact";
    public static final String col_id="Identifiant";
    public static final String col_nom="Nom";
    public static final String col_prenom="Prenom";
    public static final String col_tel="NumTel";

    String req="create table if not exists "+table_contact+"(" +col_id+" Integer primary Key autoincrement," +col_nom+" Text not null," +col_prenom+" Text not null," +col_tel+" Integer not null"+")";

    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table "+table_contact);
        onCreate(db);
    }

}
