package com.example.mitologia_chilota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CuentoHelper c = new CuentoHelper(this);

        c.insert();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listaCuentosActivity(View view) {
        Intent intent = new Intent(this, ListaCuentosActivity.class);
        startActivity(intent);
    }
}
