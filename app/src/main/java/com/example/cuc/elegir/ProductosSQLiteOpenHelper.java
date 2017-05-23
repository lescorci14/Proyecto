package com.example.cuc.elegir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CUC on 23/05/2017.
 */

public class ProductosSQLiteOpenHelper extends SQLiteOpenHelper {
    public static int version=1;
    String sql = "CREATE TABLE Productos(foto text, nombre text, categoria text)";

    public ProductosSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory){
        super(contexto,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Productos");
        db.execSQL(sql);
    }
}
