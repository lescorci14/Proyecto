package com.example.cuc.elegir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CUC on 22/05/2017.
 */

public class Personaje {
    private String foto;
    private String nombre;
    private String genero;

    public Personaje(String foto, String nombre, String genero) {
        this.foto = foto;
        this.nombre = nombre;
        this.genero = genero;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql;

        PersonajesSQLiteOpenHelper aux = new PersonajesSQLiteOpenHelper(contexto,"DBPersonajes",null);
        db = aux.getWritableDatabase();

        sql="INSERT INTO Personajes VALUES('"+this.getFoto()+"','"+this.getNombre()+"','"+this.getGenero()+"')";
        db.execSQL(sql);

        db.close();
    }
}
