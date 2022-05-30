package com.example.appescul;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Alumno extends AppCompatActivity {
    Button btnCerrar;
    TextView txtNombre, txtNumero, txtCorreo, txtFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);


        btnCerrar=(Button) findViewById(R.id.btnCerrar);
        txtNombre=(TextView)findViewById(R.id.txtNombreA);
        txtNumero=(TextView)findViewById(R.id.txtNumeroA);
        txtCorreo=(TextView)findViewById(R.id.txtCorreoA);
        txtFecha=(TextView)findViewById(R.id.txtFechaA);

        txtNombre.setText(SQLite_OpenHelper.CampoNombre);
        txtNumero.setText(SQLite_OpenHelper.CampoNumero);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Toast.makeText(getApplicationContext(), "Sesión Finalizada", Toast.LENGTH_LONG).show();
            }
        });

    }
}