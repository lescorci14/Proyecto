package com.example.cuc.elegir;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoUsuario extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Usuario> usuarios;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuario);
        tabla = (TableLayout)findViewById(R.id.tblUsuario);
        res = this.getResources();

        usuarios = DatosUsuario.traerUsuarios(getApplicationContext());

        for (int i = 0; i < usuarios.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(""+usuarios.get(i).getNombre());
            c3.setText(""+usuarios.get(i).getCelular());
            c4.setText(""+usuarios.get(i).getEdad());
            c5.setText(""+usuarios.get(i).getGenero());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);

            tabla.addView(fila);

        }
    }
}
