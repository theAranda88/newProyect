package com.example.bdfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button btnRegistro;
    TextInputLayout registerUser, registerPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("REGISTER");

        registerUser = findViewById(R.id.registerUser);
        registerPass = findViewById(R.id.registerPassword);

        btnRegistro = findViewById(R.id.btnRegistrar);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = registerUser.getEditText().getText().toString().trim();
                Register register = new Register(user, registerPass.getEditText().getText().toString());
                myRef.child("REGISTER").child(user).setValue(register);
                Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                if (user.isEmpty() || registerPass.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(Registro.this, "Todos los campos son requeridos 👍", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registro.this, MainActivity.class);
                    startActivity(intent);
                }
//                necesito saber como tener un resultado entero q me permita cla confiramaicion de la insercion de datos en la base de datos firebase???
            }
        });
    }
}