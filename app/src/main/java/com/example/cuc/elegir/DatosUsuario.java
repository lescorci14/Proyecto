package com.example.cuc.elegir;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Bry on 21/05/2017.
 */

public class DatosUsuario {

    public static ArrayList<Usuario> traerUsuarios(Context contexto){
        ArrayList<Usuario> usuarios = new ArrayList<>();

        SQLiteDatabase db;
        String sql, nombre, contraseña, celular, edad, genero;
        Usuario u;

        LoginSQLiteOpenHelper aux = new LoginSQLiteOpenHelper(contexto, "DBUsuarios", null);
        db = aux.getReadableDatabase();
        sql = "select * from Usuarios";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                nombre = c.getString(0);
                contraseña = c.getString(1);
                celular =c.getString(2);
                edad=c.getString(3);
                genero=c.getString(4);
                u = new Usuario(nombre,contraseña,celular,edad,genero);
                usuarios.add(u);
            }while (c.moveToNext());
        }

        db.close();
        return usuarios;
    }

    public static Usuario buscarUsuario(Context contexto, String nomb){
        //declarar variables
        SQLiteDatabase db;
        String sql,nombre,contraseña,celular,edad,genero;
        Usuario p=null;

        //abrir la base de datos de lectura
        LoginSQLiteOpenHelper aux=new LoginSQLiteOpenHelper(contexto,"DBUsuarios",null);
        db=aux.getReadableDatabase();
        //cursor
        sql="SELECT * FROM Usuarios WHERE name='"+nomb+"'";
        Cursor c=db.rawQuery(sql,null);
        //recorrido del cursor
        if(c.moveToFirst()){
            do{
                nombre=c.getString(0);
                contraseña=c.getString(1);
                celular =c.getString(2);
                edad=c.getString(3);
                genero=c.getString(4);
                p=new Usuario(nombre,contraseña,celular,edad,genero);
            }while(c.moveToNext());
        }
        //cerrar conexion
        db.close();
        //retorno
        return p;
    }

    public static Usuario buscarUsuario2(Context contexto, String nomb, String contra){
        //declarar variables
        SQLiteDatabase db;
        String sql,nombre,contraseña,celular,edad,genero;
        Usuario p=null;

        //abrir la base de datos de lectura
        LoginSQLiteOpenHelper aux=new LoginSQLiteOpenHelper(contexto,"DBUsuarios",null);
        db=aux.getReadableDatabase();
        //cursor
        sql="SELECT * FROM Usuarios WHERE name='"+nomb+"' AND password='"+contra+"'";
        Cursor c=db.rawQuery(sql,null);
        //recorrido del cursor
        if(c.moveToFirst()){
            do{
                nombre=c.getString(0);
                contraseña=c.getString(1);
                celular =c.getString(2);
                edad=c.getString(3);
                genero=c.getString(4);
                p=new Usuario(nombre,contraseña,celular,edad,genero);
            }while(c.moveToNext());
        }
        //cerrar conexion
        db.close();
        //retorno
        return p;
    }
}
