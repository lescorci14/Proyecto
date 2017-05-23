package com.example.cuc.elegir;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class admin extends AppCompatActivity {
    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ls = (ListView)findViewById(R.id.lvOpcionesAdmin);
        res = this.getResources();
        opc = res.getStringArray(R.array.opciones_admin);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        i = new Intent(admin.this, AgregarProducto.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(admin.this, Consultas.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }

    public void salirAdmin(View v){
        i = new Intent(admin.this, Principal.class);
        startActivity(i);
    }
}
