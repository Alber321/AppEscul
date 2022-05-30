package com.example.appescul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtnum=(EditText)findViewById(R.id.txtNumero);
                EditText txtpas=(EditText)findViewById(R.id.txtPassword);


            try{
                Cursor cursor= helper.ConsultarUsuPas(txtnum.getText().toString(),txtpas.getText().toString());
                if(cursor.getCount()>0){
                    Intent i = new Intent(getApplicationContext(),Alumno.class);
                    i.putExtra("NumeroUsuario",txtnum.getText().toString());
                    startActivity(i);
                }else if(txtnum.getText().toString().equals("ad123")&& txtpas.getText().toString().equals("ad123")) {
                    Intent i=new Intent(getApplicationContext(),Admin.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario  y/o Contraseña incorrecta",Toast.LENGTH_LONG).show();
                }
                txtnum.setText("");
                txtpas.setText("");
                txtnum.findFocus();

                    }catch (SQLException e){
                        e.printStackTrace();

                }

            }
        });

    }
}