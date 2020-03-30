package com.example.mitologia_chilota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

        TextView titulo_cuento = convertView.findViewById(R.id.historia_cuento);

        titulo_cuento.setText(cuento.getTitulo());

        return convertView;
    }
}
