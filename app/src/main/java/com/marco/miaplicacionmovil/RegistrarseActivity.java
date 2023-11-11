package com.marco.miaplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.marco.miaplicacionmovil.databinding.ActivityRegistrarseBinding;

public class RegistrarseActivity extends AppCompatActivity {

    ActivityRegistrarseBinding binding;
    DataBase dataBase;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrarseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



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

                String url = "https://instagram.com/__ddam_?igshid=NGVhN2U2NjQ0Yg==";

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

                String url = "https://www.linkedin.com/in/marco-antonio-díaz-duran-7a0536292/";

                // Crea un Intent para abrir el navegador web
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verifica si hay un navegador web disponible para manejar el Intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {

                    Toast.makeText(getApplicationContext(), "No pudimos encontrar el sitio web, intentelo mas tarde.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Spinner spinnerCountry = findViewById(R.id.spinnerCountry);

        // Crea un ArrayAdapter utilizando el array de países
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries, android.R.layout.simple_spinner_item);

        // Especifica el diseño a utilizar cuando se despliega el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Establece el adaptador en el Spinner
        spinnerCountry.setAdapter(adapter);

        // Agrega un listener para manejar la selección del usuario
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtiene el país seleccionado por el usuario
                String selectedCountry = parentView.getItemAtPosition(position).toString();

                // Si el usuario selecciona "Seleccionar País", no hagas nada
                if (!selectedCountry.equals("Seleccionar País")) {
                    // Realiza acciones basadas en el país seleccionado
                    Toast.makeText(getApplicationContext(), "País seleccionado: " + selectedCountry, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Este método se llama cuando no se selecciona nada, puedes dejarlo vacío
            }
        });

        dataBase = new DataBase(this);

        binding.registrarPantallaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = binding.correo.getText().toString();
                String password = binding.contrasenaC.getText().toString();
                String confirmPassword = binding.contrasenaConfirmacion.getText().toString();

                if (email.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(RegistrarseActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmPassword)){
                        Boolean checkUserEmail = dataBase.checkEmail(email);

                        if (!checkUserEmail){
                            Boolean insert = dataBase.insertData(email, password);

                            if (insert){
                                Toast.makeText(RegistrarseActivity.this, "Registrado", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), IniciarSesionActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegistrarseActivity.this, "Registro Fallido", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegistrarseActivity.this, "Usuario existente", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrarseActivity.this, "Contraseña invalida", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });






    }
}