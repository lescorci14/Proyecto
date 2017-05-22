package com.example.cuc.elegir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CUC on 22/05/2017.
 */

public class AdaptadorPersonaje extends BaseAdapter{
    private Context contexto;
    private ArrayList<Personaje> personajes;

    public AdaptadorPersonaje(Context contexto, ArrayList<Personaje> personajes) {
        this.contexto = contexto;
        this.personajes = personajes;
    }

    @Override
    public int getCount() {
        return personajes.size();
    }

    @Override
    public Object getItem(int positon) {
        return personajes.get(positon);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TextView nombre;
        ImageView foto;
        RadioButton r1, r2, r3;
        LayoutInflater inflater;
        View itemView;

        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personaje,null);

        nombre = (TextView)itemView.findViewById(R.id.txtNombrePersonaje);
        foto = (ImageView)itemView.findViewById(R.id.foto);
        r1 = (RadioButton)itemView.findViewById(R.id.r1caso);
        r2 = (RadioButton)itemView.findViewById(R.id.r2mato);
        r3 = (RadioButton)itemView.findViewById(R.id.r3cojo);


        nombre.setText(personajes.get(position).getNombre());
        r1.setText(itemView.getResources().getString(R.string.caso));
        r2.setText(itemView.getResources().getString(R.string.mato));
        r3.setText(itemView.getResources().getString(R.string.cojo));
        foto.setImageResource(Integer.parseInt(personajes.get(position).getFoto()));

        return itemView;
    }
}
