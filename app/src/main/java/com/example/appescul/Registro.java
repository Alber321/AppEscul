package com.example.appescul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {
    Button btnGrabarUsu;
    EditText txtNomUsu,txtNumbUsu,txtCorreousu,txtFechausu, txtContraseñaUsu,
    txtMateria1,txtMateria2,txtMateria3,txtMateria4,txtMateria5;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGrabarUsu=(Button) findViewById(R.id.btnRegisUsu2);
        txtNomUsu=(EditText) findViewById(R.id.txtNomUsu);
        txtNumbUsu=(EditText) findViewById(R.id.txtNumbUsu);
        txtCorreousu=(EditText) findViewById(R.id.txtCorreo);
        txtFechausu=(EditText) findViewById(R.id.txtfecha);
        txtContraseñaUsu=(EditText) findViewById(R.id.txtPassword);
        txtMateria1=(EditText) findViewById(R.id.txtmateria1);
        txtMateria2=(EditText) findViewById(R.id.txtmateria2);
        txtMateria3=(EditText) findViewById(R.id.txtmateria3);
        txtMateria4=(EditText) findViewById(R.id.txtmateria4);
        txtMateria5=(EditText) findViewById(R.id.txtmateria5);

        btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUsu.getText()),String.valueOf(txtNumbUsu.getText()),String.valueOf(txtCorreousu.getText()),
                        String.valueOf(txtFechausu.getText()),String.valueOf(txtContraseñaUsu.getText()),
                        String.valueOf(txtMateria1.getText()),String.valueOf(txtMateria2.getText()),
                        String.valueOf(txtMateria3.getText()),String.valueOf(txtMateria4.getText()),
                        String.valueOf(txtMateria5.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(),"Registro Exitoso",Toast.LENGTH_LONG).show();

                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

    }
}