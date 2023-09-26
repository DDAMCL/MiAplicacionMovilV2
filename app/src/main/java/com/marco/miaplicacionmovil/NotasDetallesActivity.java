package com.marco.miaplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NotasDetallesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_detalles);

    }

    public void irGuardarNota(View view){
        Intent i = new Intent(NotasDetallesActivity.this, NotaGuardadaActivity.class);
        startActivity(i);

    }
}
