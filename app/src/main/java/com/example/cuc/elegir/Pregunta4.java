package com.example.cuc.elegir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Pregunta4 extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta4);
    }

    public void aPregunta5(View v){
        i=new Intent(Pregunta4.this, Pregunta5.class);
        startActivity(i);
    }
    public void aPregunta3(View v){
        i=new Intent(Pregunta4.this, Pregunta3.class);
        startActivity(i);
    }
}
