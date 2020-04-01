package com.example.mitologia_chilota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaCuentosActivity extends AppCompatActivity {

    private ListView listaCuentos;
    private CuentoAdapter cAdapter;
    ArrayList <Cuento> cuentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e){}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cuentos);

        listaCuentos = (ListView) findViewById(R.id.lista);

        CuentoHelper db = new CuentoHelper(this);

        cuentos = db.getCuentos();

        cAdapter = new CuentoAdapter(this, cuentos);

        listaCuentos.setAdapter(cAdapter);

        listaCuentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaCuentosActivity.this, CuentoActivity.class);
                intent.putExtra("data", cuentos.get(position));
                startActivity(intent);
            }
        });
    }
}
