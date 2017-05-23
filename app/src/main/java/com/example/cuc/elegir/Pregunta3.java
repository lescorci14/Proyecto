package com.example.cuc.elegir;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Pregunta3 extends AppCompatActivity {
    private Spinner spn;
    private String[] opc;
    private Resources res;
    private ArrayAdapter<String> adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3);
        spn = (Spinner)findViewById(R.id.cmbDias);

        res = this.getResources();
        opc = res.getStringArray(R.array.dias);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);

        spn.setAdapter(adapter);

    }

    public void aPregunta4(View v){
        i=new Intent(Pregunta3.this, Pregunta4.class);
        startActivity(i);
    }
    public void aPregunta2(View v){
        i=new Intent(Pregunta3.this, Pregunta2.class);
        startActivity(i);
    }

}
