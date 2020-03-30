package com.example.mitologia_chilota;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CuentoActivity  extends Activity {

    private Cuento cuento;
    private TextView titulo_cuento;
    private TextView historia_cuento;
    private ImageView imagen_cuento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuento);

        cuento = (Cuento) getIntent().getSerializableExtra("data");

        titulo_cuento =  (TextView) findViewById(R.id.titulo_cuento);
        historia_cuento =  (TextView) findViewById(R.id.historia_cuento);
        imagen_cuento = (ImageView) findViewById(R.id.imagen_cuento);

        titulo_cuento.setText(cuento.getTitulo());
        historia_cuento.setText(cuento.getHistoria());
        imagen_cuento.setImageResource(getResources().getIdentifier( "com.example.mitologia_chilota:drawable/" + cuento.getRuta_imagen(), null, null));
    }
}
