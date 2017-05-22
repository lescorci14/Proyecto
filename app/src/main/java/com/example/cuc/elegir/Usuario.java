package com.example.cuc.elegir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Bry on 21/05/2017.
 */

public class Usuario {
    private String nombre;
    private String contraseña;
    private String celular;
    private String edad;
    private String genero;

    public Usuario(String nombre, String contraseña, String celular, String edad, String genero) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.celular = celular;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCelular(){ return celular; }

    public void setCelular(String celular) { this.celular = celular; }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public void guardar(Context contexto){
        //declarar variables
        SQLiteDatabase db;
        String sql;
        //abriendo conexion en modo escritura
        LoginSQLiteOpenHelper aux=new LoginSQLiteOpenHelper(contexto,"DBUsuarios",null);
        db=aux.getWritableDatabase();
        sql="INSERT INTO Usuarios VALUES('"+this.getNombre()+"','"+this.getContraseña()+"','"+this.getCelular()+"','"+this.getEdad()+"','"+this.getGenero()+"')";
        db.execSQL(sql);
        db.close();
    }
}
