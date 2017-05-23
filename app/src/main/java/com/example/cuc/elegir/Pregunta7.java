package com.example.cuc.elegir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Pregunta7 extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta7);
    }

    public void aPregunta8(View v){
        i=new Intent(Pregunta7.this, Pregunta8.class);
        startActivity(i);
    }
    public void aPregunta6(View v){
        i = new Intent(Pregunta7.this, Pregunta6.class);
        startActivity(i);
    }

}
