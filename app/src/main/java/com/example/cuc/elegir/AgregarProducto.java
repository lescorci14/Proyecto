package com.example.cuc.elegir;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AgregarProducto extends AppCompatActivity {
    private EditText cajaNombreImg;
    private String[] opc1,opc2, opc3;
    private ArrayAdapter<String> adapter1,adapter2;
    private Spinner categoria, listaImg;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        res = this.getResources();

        cajaNombreImg = (EditText)findViewById(R.id.txtNombreAgregar);
        categoria = (Spinner)findViewById(R.id.cmbCategoria);
        listaImg = (Spinner)findViewById(R.id.cmbListImg);

        opc1 = res.getStringArray(R.array.categorias);
        opc2 = res.getStringArray(R.array.lista);

        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc1);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc2);

        categoria.setAdapter(adapter1);
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
        String nombre, foto, cate, list;
        int ft=0;

        if(validar()){
            nombre = cajaNombreImg.getText().toString();
            cate = categoria.getSelectedItem().toString();
            list = listaImg.getSelectedItem().toString();

            if(list.equalsIgnoreCase(res.getString(R.string.accM))){
                ft = 0;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accE))){
                ft = 1;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accH))){
                ft = 2;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accP))){
                ft = 3;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accB))){
                ft = 4;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accC))){
                ft = 5;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accHi))){
                ft = 6;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accMa))){
                ft = 7;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accS))){
                ft = 8;
            }
            if(list.equalsIgnoreCase(res.getString(R.string.accR))){
                ft = 9;
            }

            foto = String.valueOf(fotoE(ft));
            Producto p = new Producto(foto,nombre,cate);
            p.guardar(getApplicationContext());
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.guardado2)).show();
            limpiar();
        }
    }

    public int fotoE(int numero){
        int fotos[] = {R.drawable.accesorio_mujeres,R.drawable.accesorios_electronicos,R.drawable.accesorios_hombre,
                R.drawable.accesorios_playa,R.drawable.buceo,R.drawable.calzado,
                R.drawable.higiene,R.drawable.maquillaje,R.drawable.pastillas,R.drawable.ropa};

        return fotos[numero];
    }

    public void limpiar(){
        cajaNombreImg.setText("");
        cajaNombreImg.requestFocus();
    }
}
