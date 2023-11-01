package com.marco.miaplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.*;


import java.util.concurrent.TimeUnit;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button perfil = findViewById(R.id.perfil);

        // Configura un escuchador de clic para el botón
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea una intención para abrir la ActividadDestino
                Intent intent = new Intent(MainActivity.this, PefilActivity.class);

                // Inicia la nueva actividad
                startActivity(intent);
            }
        });

        ImageView imagenFacebook = findViewById(R.id.imagenFacebook);

        imagenFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para abrir el navegador web
                String url = "https://www.facebook.com/profile.php?id=100015640921378&mibextid=9R9pXO"; // Reemplaza con la URL que desees abrir

                // Crea un Intent para abrir el navegador web
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verifica si hay un navegador web disponible para manejar el Intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // No se encontró un navegador web
                    Toast.makeText(getApplicationContext(), "No pudimos encontrar el sitio web, intentelo mas tarde.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView imagenInstagram = findViewById(R.id.imagenInstagram);

        imagenInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para abrir el navegador web
                String url = "https://instagram.com/__ddam_?igshid=NGVhN2U2NjQ0Yg=="; // Reemplaza con la URL que desees abrir

                // Crea un Intent para abrir el navegador web
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verifica si hay un navegador web disponible para manejar el Intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // No se encontró un navegador web
                    Toast.makeText(getApplicationContext(), "No pudimos encontrar el sitio web, intentelo mas tarde.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView imagenLinkedin = findViewById(R.id.imagenLinkedin);

        imagenLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para abrir el navegador web
                String url = "https://www.linkedin.com/in/marco-antonio-díaz-duran-7a0536292/"; // Reemplaza con la URL que desees abrir

                // Crea un Intent para abrir el navegador web
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verifica si hay un navegador web disponible para manejar el Intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // No se encontró un navegador web
                    Toast.makeText(getApplicationContext(), "No pudimos encontrar el sitio web, intentelo mas tarde.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Define las restricciones (opcional)
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        // Crea una solicitud de trabajo periódica
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(
                NotificationWorker.class,
                1, // Intervalo en días
                TimeUnit.DAYS)
                .setConstraints(constraints)
                .build();

        // Programa la tarea periódica
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
                "notification_job",
                ExistingPeriodicWorkPolicy.REPLACE, // Puedes ajustar la política según tus necesidades
                periodicWorkRequest
        );



    }

    public void irIniciar(View view){
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);

    }

    public void irRegistrarse(View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);

    }





}