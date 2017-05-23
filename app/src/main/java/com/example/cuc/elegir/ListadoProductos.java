package com.example.cuc.elegir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoProductos extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Producto> productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);

        lista = (ListView)findViewById(R.id.lvProductos);
        productos = DatosProducto.traerProductos(getApplicationContext());

        AdaptadorProducto adapter = new AdaptadorProducto(this,productos);
        lista.setAdapter(adapter);
    }
}
