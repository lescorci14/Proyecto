package com.example.cuc.elegir;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegistrarUsuario extends AppCompatActivity {
    private Resources res;
    private EditText cajaNombre, cajaContra, cajaConfirmar, cajaCelular, cajaEdad;
    private RadioButton r1masculino, r2femenino;
    private CheckBox chkacepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        res = this.getResources();

        cajaNombre = (EditText)findViewById(R.id.txtNombreUsuario);
        cajaContra = (EditText)findViewById(R.id.txtContraseñaUsuario);
        cajaConfirmar = (EditText)findViewById(R.id.txtConfirmarContraseña);
        cajaCelular = (EditText)findViewById(R.id.txtCelularUsuario);
        cajaEdad = (EditText)findViewById(R.id.txtEdadUsuario);

        r1masculino = (RadioButton)findViewById(R.id.r1GeneroUsuario);
        r2femenino = (RadioButton)findViewById(R.id.r2GeneroUsuario);

        chkacepto = (CheckBox)findViewById(R.id.checkBoxUsuarios);

    }

    public void guardar(View v){
        String nombre, contraseña, celular, edad, genero="";
        Usuario a, b;

        if(validarCampos()){
            nombre = cajaNombre.getText().toString();
            b = DatosUsuario.buscarUsuario(getApplicationContext(), nombre);
            if(b==null){
                contraseña = cajaContra.getText().toString();
                celular = cajaCelular.getText().toString();
                edad = cajaEdad.getText().toString();
                if(r1masculino.isChecked()){
                    genero = res.getString(R.string.masculino);
                }else{
                    genero = res.getString(R.string.femenino);
                }

                a = new Usuario(nombre,contraseña,celular,edad,genero);
                a.guardar(getApplicationContext());
                new AlertDialog.Builder(this).setMessage(res.getString(R.string.guardado)).setCancelable(true).show();
                limpiar();
            }else{
                new AlertDialog.Builder(this).setMessage(res.getString(R.string.existir)).setCancelable(true).show();
            }
        }

    }

    public void terminos(View v){
        new AlertDialog.Builder(this).setTitle(res.getString(R.string.terminos_condiciones)).setMessage(res.getString(R.string.lorem)).setCancelable(true).show();
    }

    public boolean validarCampos(){
        String edad = cajaEdad.getText().toString();
        int req = 14, eda = 0;


        if(cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(res.getString(R.string.error_name));
            cajaNombre.requestFocus();
            return false;
        }

        if(cajaContra.getText().toString().isEmpty()){
            cajaContra.setError(res.getString(R.string.error_contra));
            cajaContra.requestFocus();
            return false;
        }

        if(cajaConfirmar.getText().toString().isEmpty()){
            cajaConfirmar.setError(res.getString(R.string.error_confirmar));
            cajaConfirmar.requestFocus();
            return false;
        }

        if(!(cajaContra.getText().toString().equalsIgnoreCase(cajaConfirmar.getText().toString()))){
            cajaConfirmar.setError(res.getString(R.string.error_coincidir));
            return false;
        }

        if(cajaCelular.getText().toString().isEmpty()){
            cajaCelular.setError(res.getString(R.string.error_celular));
            cajaCelular.requestFocus();
            return false;
        }

        if(cajaEdad.getText().toString().isEmpty()){
            cajaEdad.setError(res.getString(R.string.error_edad));
            cajaEdad.requestFocus();
        }

        eda = Integer.parseInt(edad);

        if(eda<req){
            cajaEdad.setError(res.getString(R.string.error_menor));
            cajaEdad.requestFocus();
            return false;
        }

        if(!chkacepto.isChecked()){
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.error_acepto)).setCancelable(true).show();
            return false;
        }

        return true;
    }

    public void limpiar(){
        cajaNombre.setText("");
        cajaContra.setText("");
        cajaConfirmar.setText("");
        cajaCelular.setText("");
        cajaEdad.setText("");

        cajaNombre.requestFocus();
    }



}
