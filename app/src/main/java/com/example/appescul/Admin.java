package com.example.appescul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button btnCrear,brnSalir,btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btnCrear=(Button)findViewById(R.id.btnCrear);
        brnSalir=(Button)findViewById(R.id.btnSalir);

        btnConsultar=(Button)findViewById(R.id.btnConsultar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),Consultar.class);
                startActivity(i);
            }
        });


        brnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),Registro.class);
                startActivity(i);
            }
        });

    }
}