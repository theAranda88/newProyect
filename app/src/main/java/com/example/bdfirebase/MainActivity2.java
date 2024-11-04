package com.example.bdfirebase;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
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

public class MainActivity2 extends AppCompatActivity {

    TextInputLayout edtEstadoH2o, edtValorH20, edtCodTH2o, edtEstadoTem, edtValorMeTem, edtCodigoTem, edtEstadoNi, edtvalorMeNi, edtCodigoNi;
    Button btnInsertar, btnEnlistar;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//------------Instancia de Firebase y conexion a la base de datos----------------
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("BD");
//------------Referencias de id de los campos de texto----------------
        edtEstadoH2o = findViewById(R.id.edtEstadoH);
        edtValorH20 = findViewById(R.id.edtValorMeH);
        edtCodTH2o = findViewById(R.id.edtCodH);

        edtEstadoTem = findViewById(R.id.edtEstadoT);
        edtValorMeTem = findViewById(R.id.edtValorMeT);
        edtCodigoTem = findViewById(R.id.edtCodigoT);

        edtEstadoNi = findViewById(R.id.edtEstadoN);
        edtvalorMeNi = findViewById(R.id.edtValorMeN);
        edtCodigoNi = findViewById(R.id.edtCodigoN);
//------------Referrencia del botone de insertar----------------
        btnInsertar = findViewById(R.id.btnInsertar);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userIdH2o = (edtCodTH2o.getEditText().getText().toString().trim());
                String userIdTem = (edtCodigoTem.getEditText().getText().toString().trim());
                String userIdNit = (edtCodigoNi.getEditText().getText().toString().trim());

                H2o h2o = new H2o( userIdH2o, edtEstadoH2o.getEditText().getText().toString(), edtValorH20.getEditText().getText().toString());
                Temperatura temperatura = new Temperatura( userIdTem, edtEstadoTem.getEditText().getText().toString(), edtValorMeTem.getEditText().getText().toString());
                Nitrito nitrito = new Nitrito( userIdNit, edtEstadoNi.getEditText().getText().toString(), edtvalorMeNi.getEditText().getText().toString());

                myRef.child("H2o").child(userIdH2o).setValue(h2o);
                myRef.child("Temperatura").child(userIdTem).setValue(temperatura);
                myRef.child("Nitrito").child(userIdNit).setValue(nitrito);

                Toast.makeText(MainActivity2.this, "H2o, Temperatura y Nitrito datos Insertados", Toast.LENGTH_LONG).show();
            }
        });

        btnEnlistar = findViewById(R.id.btnEnlistar);
        btnEnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        //whenever data at this location is updated.
                        String value = dataSnapshot.child("H2o").child("codigoSensorH2o").getValue(String.class);
                        Log.d(TAG, "Value is: " + value);
                        Toast.makeText(MainActivity2.this, ""+value, Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

            }
        });




    }
}