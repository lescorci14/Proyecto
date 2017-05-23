package com.example.cuc.elegir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Pregunta9 extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta9);
    }

    public void aPregunta10(View v){
        i=new Intent(Pregunta9.this, Pregunta10.class);
        startActivity(i);
    }
    public void aPregunta9(View v){
        i = new Intent(Pregunta9.this, Pregunta9.class);
        startActivity(i);
    }
}
