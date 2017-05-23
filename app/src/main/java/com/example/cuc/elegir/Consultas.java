package com.example.cuc.elegir;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Consultas extends AppCompatActivity {
    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        ls=(ListView)findViewById(R.id.lvConsultas);
        res = this.getResources();
        opc = res.getStringArray(R.array.consultas_admin);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Consultas.this, ListadoProductos.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Consultas.this, ListadoUsuario.class);
                        startActivity(i);
                        break;
                }
            }
        });

    }
}
