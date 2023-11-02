package com.marco.miaplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PefilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pefil);

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
    }

    public void irLogin(View view){
        Intent i = new Intent(PefilActivity.this, IniciarSesionActivity.class);
        startActivity(i);

    }

    public void irMapa(View view) {
        Intent i = new Intent(PefilActivity.this, Splash2Activity.class);
        startActivity(i);
    }

}