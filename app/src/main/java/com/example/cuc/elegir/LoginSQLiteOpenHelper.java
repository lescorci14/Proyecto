package com.example.cuc.elegir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bry on 21/05/2017.
 */

public class LoginSQLiteOpenHelper extends SQLiteOpenHelper{
    private static int version=1;
    String sql="CREATE TABLE Usuarios(name text,password text, celular text, edad text,genero text)";


    public LoginSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory){
        super(contexto,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuarios");
        sqLiteDatabase.execSQL(sql);
    }
}
