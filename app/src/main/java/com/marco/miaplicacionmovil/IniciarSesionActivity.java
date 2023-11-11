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

import com.google.android.material.button.MaterialButton;
import com.marco.miaplicacionmovil.databinding.ActivityIniciarSesionBinding;

public class IniciarSesionActivity extends AppCompatActivity {

    ActivityIniciarSesionBinding binding;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIniciarSesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataBase = new DataBase(this);

        binding.iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = binding.correo.getText().toString();
                String password = binding.contrasena.getText().toString();

                if (email.equals("") || password.equals(""))
                    Toast.makeText(IniciarSesionActivity.this, "All fields are mamndatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = dataBase.checkEmailPassword(email, password);
                    
                    if (checkCredentials == true){
                        Toast.makeText(IniciarSesionActivity.this, "Iniciando Sesion", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), NotasActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(IniciarSesionActivity.this, "Inicio de Sesion Fallido", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IniciarSesionActivity.this, NotasActivity.class);
                startActivity(intent);
            }
        });







        ImageView imagenFacebook = findViewById(R.id.imagenFacebook);

        imagenFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://www.facebook.com/profile.php?id=100015640921378&mibextid=9R9pXO";

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


}