package com.example.bdfirebase;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdfirebase.adapter.H2oAdapter;
import com.example.bdfirebase.adapter.NitritoAdapter;
import com.example.bdfirebase.adapter.TemperaturaAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    TextInputLayout edtEstadoH2o, edtValorH20, edtCodTH2o, edtEstadoTem, edtValorMeTem, edtCodigoTem, edtEstadoNi, edtvalorMeNi, edtCodigoNi;
    Button btnInsertar, btnEnlistar;
    FirebaseDatabase database;
    DatabaseReference myRef;
    RecyclerView recyclerView;
    H2oAdapter h2oAdapter;
    List<H2o> h2oList;
    NitritoAdapter nitritoAdapter;
    List<Nitrito> nitritoList;
    TemperaturaAdapter temperaturaAdapter;
    List<Temperatura> temperaturaList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//------------Configuracion del recycleView----------------------
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        h2oList = new ArrayList<>();
        h2oAdapter = new H2oAdapter(h2oList);
        recyclerView.setAdapter(h2oAdapter);
//        nitritoList = new ArrayList<>();
//        nitritoAdapter = new NitritoAdapter(nitritoList);
//        recyclerView.setAdapter(nitritoAdapter);
//        temperaturaList = new ArrayList<>();
//        temperaturaAdapter = new TemperaturaAdapter(temperaturaList);
//        recyclerView.setAdapter(temperaturaAdapter);
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

                H2o h2o = new H2o(userIdH2o, edtEstadoH2o.getEditText().getText().toString(), edtValorH20.getEditText().getText().toString());
                Temperatura temperatura = new Temperatura(userIdTem, edtEstadoTem.getEditText().getText().toString(), edtValorMeTem.getEditText().getText().toString());
                Nitrito nitrito = new Nitrito(userIdNit, edtEstadoNi.getEditText().getText().toString(), edtvalorMeNi.getEditText().getText().toString());

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
                cargarDatosFirebaseH2o();
//                cargarDatosFirebaseNitrito();
//                cargarDatosFirebaseTemperatura();
            }
        });
    }
    private void cargarDatosFirebaseH2o() {
        Log.d(TAG, "Iniciando carga de datos de Firebase.");
        myRef.child("H2o").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                h2oList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d(TAG, "Snapshot data: " + snapshot.getValue().toString());
                    H2o h2o = snapshot.getValue(H2o.class);
                    if (h2o != null) {
                        h2oList.add(h2o);
                        Log.d(TAG, "Añadido a la lista: " + h2o.toString());
                    } else {
                        Log.w(TAG, "El objeto H2o es nulo");
                    }
                }
                h2oAdapter.notifyDataSetChanged(); // Refresca el RecyclerView
                Log.d(TAG, "Datos actualizados en el adapter");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
//    private void cargarDatosFirebaseNitrito() {
//        Log.d(TAG, "Iniciando carga de datos de Firebase.");
//        myRef.child("Nitrito").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                nitritoList.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Log.d(TAG, "Snapshot data: " + snapshot.getValue().toString());
//                    Nitrito nitrito = snapshot.getValue(Nitrito.class);
//                    if (nitrito != null) {
//                        nitritoList.add(nitrito);
//                        Log.d(TAG, "Añadido a la lista: " + nitrito.toString());
//                    }else{
//                        Log.w(TAG, "El objeto Nitrito es nulo");
//                    }
//                }
//                nitritoAdapter.notifyDataSetChanged(); // Refresca el RecyclerView
//                Log.d(TAG, "Datos actualizados en el adapter");
//                    }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });
//    }
//    private void cargarDatosFirebaseTemperatura(){
//        myRef.child("Temperatura").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                temperaturaList.clear();
//                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
//                    Log.d(TAG, "Snapshot data: " + snapshot1.getValue().toString());
//                    Temperatura temperatura = snapshot1.getValue(Temperatura.class);
//                    if (temperatura != null) {
//                        temperaturaList.add(temperatura);
//                        Log.d(TAG, "Añadido a la lista: " + temperatura.toString());
//                    } else {
//                        Log.w(TAG, "El objeto Temperatura es nulo");
//                    }
//                }
//                temperaturaAdapter.notifyDataSetChanged(); // Refresca el RecyclerView
//                Log.d(TAG, "Datos actualizados en el adapter");
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });
//    }



}
