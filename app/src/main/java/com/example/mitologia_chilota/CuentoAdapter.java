package com.example.mitologia_chilota;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CuentoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cuento> listCuentos;

    public CuentoAdapter(Context context, ArrayList<Cuento> listCuentos) {
        this.context = context;
        this.listCuentos = listCuentos;
    }

    @Override
    public int getCount() {
        return listCuentos.size();
    }

    @Override
    public Object getItem(int position) {
        return listCuentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cuento cuento = (Cuento) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.cuento, null);

        TextView titulo_cuento = convertView.findViewById(R.id.titulo);
        titulo_cuento.setText(cuento.getTitulo());

        ImageView btn_cuento = convertView.findViewById(R.id.img_cuento);
        btn_cuento.setImageResource(convertView.getResources().getIdentifier( "com.example.mitologia_chilota:drawable/" + cuento.getRuta_imagen(), null, null));
        return convertView;
    }
}
