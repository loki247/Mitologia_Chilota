package com.example.mitologia_chilota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.opengl.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FrameLayout img_fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CuentoHelper c = new CuentoHelper(this);
        c.insert();

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e){}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] fotos_fondo = {
                "chiloe_01",
                "chiloe_02",
                "chiloe_03",
                "chiloe_04",
                "chiloe_05",
                "chiloe_06",
                "chiloe_07"
        };

        Random ran = new Random();
        int i = ran.nextInt(fotos_fondo.length);
        img_fondo = (FrameLayout) findViewById(R.id.layout_inicio);
        img_fondo.setBackgroundResource(getResources().getIdentifier( "com.example.mitologia_chilota:drawable/" + fotos_fondo[i], null, null));

    }

    public void listaCuentosActivity(View view) {
        Intent intent = new Intent(this, ListaCuentosActivity.class);
        startActivity(intent);
    }
}
