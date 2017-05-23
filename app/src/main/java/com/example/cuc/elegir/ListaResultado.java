package com.example.cuc.elegir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaResultado extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Producto> productos;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_resultado);

        lista = (ListView)findViewById(R.id.lstResultado);
        productos = DatosProducto.traerProductos(getApplicationContext());

        AdaptadorProducto adapter = new AdaptadorProducto(this,productos);
        lista.setAdapter(adapter);
    }

    public void volverInicio(View v){
        i = new Intent(ListaResultado.this, PlayView.class);
        startActivity(i);
    }

}
