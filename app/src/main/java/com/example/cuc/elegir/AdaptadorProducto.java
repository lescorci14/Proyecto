package com.example.cuc.elegir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CUC on 23/05/2017.
 */

public class AdaptadorProducto extends BaseAdapter {
    private Context contexto;
    private ArrayList<Producto> productos;

    public AdaptadorProducto(Context contexto, ArrayList<Producto> productos) {
        this.contexto = contexto;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int positon) {
        return productos.get(positon);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        TextView nombre, cate;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_producto,null);

        nombre = (TextView)itemView.findViewById(R.id.txtNombreProducto);
        cate = (TextView)itemView.findViewById(R.id.txtCategoriaProducto);
        foto = (ImageView)itemView.findViewById(R.id.foto);


        nombre.setText(productos.get(position).getNombre());
        cate.setText(productos.get(position).getCategoria());
        foto.setImageResource(Integer.parseInt(productos.get(position).getFoto()));

        return itemView;
    }
}
