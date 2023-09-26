package com.marco.miaplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class NotasActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        Calificanos calificanos = new Calificanos(NotasActivity.this);
        calificanos.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        calificanos.setCancelable(false);
        calificanos.show();

    }




    public void irNotasDetalles(View view){
        Intent i = new Intent(NotasActivity.this, NotasDetallesActivity.class);
        startActivity(i);

    }



}