package com.example.cuc.elegir;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    private Resources res;
    private EditText cajaUsuario, cajaContra;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res = this.getResources();

        cajaUsuario = (EditText)findViewById(R.id.txtNombreLogin);
        cajaContra = (EditText)findViewById(R.id.txtContraLogin);
    }

    public void entrar(View v){
        String nombre, contra;
        Usuario a,b;

        if(camposVacios()) {
            nombre = cajaUsuario.getText().toString();

            contra = cajaContra.getText().toString();

            if (nombre.equalsIgnoreCase(res.getString(R.string.admin)) && contra.equalsIgnoreCase(res.getString(R.string.admin_pass))) {
                i = new Intent(Principal.this, admin.class);
                startActivity(i);
                limpiar();
            } else if(nombre.equalsIgnoreCase(res.getString(R.string.admin))) {
                new AlertDialog.Builder(this).setMessage(res.getString(R.string.coincidir_login)).setCancelable(true).show();
            }else{

                a = DatosUsuario.buscarUsuario(getApplicationContext(), nombre);
                if (a==null) {
                    new AlertDialog.Builder(this).setMessage(res.getString(R.string.error_usurio)).setCancelable(true).show();
                } else {
                    b = DatosUsuario.buscarUsuario2(getApplicationContext(), nombre, contra);
                    if (b == null) {
                        new AlertDialog.Builder(this).setMessage(res.getString(R.string.coincidir_login)).setCancelable(true).show();
                    } else {
                        i = new Intent(Principal.this, PlayView.class);
                        startActivity(i);
                        limpiar();
                    }
                }
            }
        }
    }


    public boolean camposVacios(){
        if(cajaUsuario.getText().toString().isEmpty()){
            cajaUsuario.setError(res.getString(R.string.error_name));
            cajaUsuario.requestFocus();
            return false;
        }

        if(cajaContra.getText().toString().isEmpty()){
            cajaContra.setError(res.getString(R.string.error_contra));
            cajaContra.requestFocus();
            return false;
        }

        return true;
    }

    public void limpiar(){
        cajaUsuario.setText("");
        cajaContra.setText("");
        cajaUsuario.requestFocus();
    }

    public void registrar(View v){
        i = new Intent(Principal.this, RegistrarUsuario.class);
        startActivity(i);
    }
    public void sobreNosotros(View v){
        i = new Intent(Principal.this, Nosotros.class);
        startActivity(i);
    }
}
