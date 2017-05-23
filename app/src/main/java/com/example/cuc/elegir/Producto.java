package com.example.cuc.elegir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CUC on 23/05/2017.
 */

public class Producto {
    private String foto;
    private String nombre;
    private String categoria;

    public Producto(String foto, String nombre, String categoria) {
        this.foto = foto;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql;

        ProductosSQLiteOpenHelper aux = new ProductosSQLiteOpenHelper(contexto,"DBProductos",null);
        db = aux.getWritableDatabase();

        sql="INSERT INTO Productos VALUES('"+this.getFoto()+"','"+this.getNombre()+"','"+this.getCategoria()+"')";
        db.execSQL(sql);

        db.close();
    }
}
