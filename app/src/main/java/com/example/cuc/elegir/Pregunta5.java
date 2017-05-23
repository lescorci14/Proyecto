package com.example.cuc.elegir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Pregunta5 extends AppCompatActivity {
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta5);
    }

    public void aPregunta6(View v){
        i=new Intent(Pregunta5.this, Pregunta6.class);
        startActivity(i);
    }
    public void aPregunta4(View v){
        i = new Intent(Pregunta5.this, Pregunta4.class);
        startActivity(i);
    }
}
