package com.example.bdfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextInputLayout usuario, contrasena;
    Button btnIngresar;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("REGISTER");

        usuario = findViewById(R.id.user);
        contrasena = findViewById(R.id.password);

        registrarse = findViewById(R.id.btnRegistrateMain);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });

        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--------------------traigo datos d mis cajas d texto-----------------------
                String user = usuario.getEditText().getText().toString().trim();
                String pass = contrasena.getEditText().getText().toString().trim();

            DatabaseReference userRef = database.getReference("REGISTER").child("REGISTER").child(user);

            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        //-------------si el usuRIO EXISTE-----------
                        String storedPassword = dataSnapshot.child("pass").getValue(String.class).trim();

                        if(pass.trim().equals(storedPassword)) {
                            // Comparar la contraseña ingresada con la almacenada
                            Toast.makeText(MainActivity.this, "Bienvenido " + user, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                        }else{
                            // Contraseña incorrecta
                            Toast.makeText(MainActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        // Usuario no existe
                        Toast.makeText(MainActivity.this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Manejar errores de la base de datos
                    Toast.makeText(MainActivity.this, "Error al acceder a la base de datos", Toast.LENGTH_SHORT).show();
                }
            });









            }
        });


    }
}