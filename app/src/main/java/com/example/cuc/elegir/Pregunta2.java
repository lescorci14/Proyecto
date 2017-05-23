package com.example.cuc.elegir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Pregunta2 extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);
    }

    public void aPregunta3(View v){
        i=new Intent(Pregunta2.this, Pregunta3.class);
        startActivity(i);
    }
    public void aPregunta1(View v){
        i=new Intent(Pregunta2.this, Pregunta1.class);
        startActivity(i);
    }
}
