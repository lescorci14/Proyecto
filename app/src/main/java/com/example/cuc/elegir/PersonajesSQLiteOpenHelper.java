package com.example.cuc.elegir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CUC on 22/05/2017.
 */

public class PersonajesSQLiteOpenHelper extends SQLiteOpenHelper {
    public static int version=1;
    String sql = "CREATE TABLE Personajes(foto text, nombre text, genero text)";

    public PersonajesSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory){
        super(contexto,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Personajes");
        db.execSQL(sql);
    }
}
