package com.example.cuc.elegir;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by CUC on 23/05/2017.
 */

public class DatosProducto {

    public static ArrayList<Producto> traerProductos(Context contexto) {
        SQLiteDatabase db;
        String sql;
        String foto;
        String nombre;
        String categoria;

        ArrayList<Producto> productos =  new ArrayList();

        ProductosSQLiteOpenHelper aux = new ProductosSQLiteOpenHelper(contexto,"DBProductos",null);
        db = aux.getReadableDatabase();

        sql = "Select * from Productos";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                nombre = c.getString(1);
                categoria = c.getString(2);

                Producto p = new Producto(foto,nombre,categoria);
                productos.add(p);
            }while(c.moveToNext());
        }

        db.close();

        return productos;
    }
}
