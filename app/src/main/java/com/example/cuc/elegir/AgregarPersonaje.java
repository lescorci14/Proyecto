package com.example.cuc.elegir;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AgregarPersonaje extends AppCompatActivity {
    private EditText cajaNombreImg;
    private String[] opc1,opc2, opc3;
    private ArrayAdapter<String> adapter1,adapter2, adapter3;
    private Spinner genero, listaImg;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_personaje);
        res = this.getResources();

        cajaNombreImg = (EditText)findViewById(R.id.txtNombreAgregar);
        genero = (Spinner)findViewById(R.id.cmbGenero);
        listaImg = (Spinner)findViewById(R.id.cmbListImg);

        opc1 = res.getStringArray(R.array.generos);
        opc2 = res.getStringArray(R.array.lista);

        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc1);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc2);

        genero.setAdapter(adapter1);
        listaImg.setAdapter(adapter2);

    }

    public boolean validar(){
        if(cajaNombreImg.getText().toString().isEmpty()){
            cajaNombreImg.setError(res.getString(R.string.error_img));
            cajaNombreImg.requestFocus();
            return false;
        }

        return true;
    }

    public void agregarP(View v){
        String nombre, foto, gene, list;
        int ft=0;

        if(validar()){
            nombre = cajaNombreImg.getText().toString();
            gene = genero.getSelectedItem().toString();
            list = listaImg.getSelectedItem().toString();

            if(list.equalsIgnoreCase(res.getString(R.string.davidB))){
                ft = 0;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.hugh))){
                ft = 2;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.joe))){
                ft = 3;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.mark))){
                ft = 4;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.emma))){
                ft = 1;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.megan))){
                ft = 5;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.rihana))){
                ft = 6;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.scarlett))){
                ft = 7;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.sofia))){
                ft = 8;
            }

            foto = String.valueOf(fotoE(ft));
            Personaje p = new Personaje(foto,nombre,gene);
            p.guardar(getApplicationContext());
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.guardado2)).show();
            limpiar();
        }
    }

    public int fotoE(int numero){
        int fotos[] = {R.drawable.davidbeckham,R.drawable.emmawatson,R.drawable.hughjackman,
                R.drawable.joemanganiello,R.drawable.markzuckerberg,R.drawable.meganfox,
                R.drawable.rihana,R.drawable.scarlettjohansson,R.drawable.sofiavergara};

        return fotos[numero];
    }

    public void limpiar(){
        cajaNombreImg.setText("");
        cajaNombreImg.requestFocus();
    }

}

