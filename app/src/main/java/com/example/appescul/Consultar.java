package com.example.appescul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Consultar extends AppCompatActivity {
    Button btnBuscar, btnAtras, btnActualizar, btnEliminar;
    EditText NumeroC,NombreC,CorreoC,FechaC, MateriaC1,
            MateriaC2,MateriaC3,MateriaC4,MateriaC5;
    SQLite_OpenHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        conn=new SQLite_OpenHelper(getApplicationContext(),"BD1",null,1);

        btnBuscar=(Button) findViewById(R.id.btnBuscar);
        btnAtras=(Button)findViewById(R.id.btnVolver);
        btnActualizar=(Button)findViewById(R.id.btnActualizar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        NumeroC=(EditText) findViewById(R.id.NumeroConsulta);NombreC=(EditText) findViewById(R.id.NombreConsulta);
        CorreoC=(EditText) findViewById(R.id.CorreoConsulta);FechaC=(EditText) findViewById(R.id.FechaConsulta);
        MateriaC1=(EditText) findViewById(R.id.MateriaC1);MateriaC2=(EditText) findViewById(R.id.MateriaC2);
        MateriaC3=(EditText) findViewById(R.id.MateriaC3);MateriaC4=(EditText) findViewById(R.id.MateriaC4);
        MateriaC5=(EditText) findViewById(R.id.MateriaC5);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=conn.getWritableDatabase();
                String[] parametros={NumeroC.getText().toString()};

                db.delete(SQLite_OpenHelper.TABLA_USUARIO,SQLite_OpenHelper.CampoNumero+"=?",parametros);

                Toast.makeText(getApplicationContext(),"Usuario Eliminado",Toast.LENGTH_LONG).show();
                limpiar();
                db.close();
            }
            private void limpiar() {
                NumeroC.setText("");NombreC.setText("");CorreoC.setText("");FechaC.setText("");MateriaC1.setText("");
                MateriaC2.setText("");MateriaC3.setText("");MateriaC4.setText("");MateriaC5.setText("");
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarUsuario();
            }

            private void actualizarUsuario() {
                SQLiteDatabase db=conn.getWritableDatabase();
                String[] parametros={NumeroC.getText().toString()};
                ContentValues values=new ContentValues();
                values.put(SQLite_OpenHelper.CampoNombre,NombreC.getText().toString());
                values.put(SQLite_OpenHelper.CampoCorreo,CorreoC.getText().toString());
                values.put(SQLite_OpenHelper.CampoFecha,FechaC.getText().toString());
                values.put(SQLite_OpenHelper.CampoMateria1,MateriaC1.getText().toString());
                values.put(SQLite_OpenHelper.CampoMateria2,MateriaC2.getText().toString());
                values.put(SQLite_OpenHelper.CampoMateria3,MateriaC3.getText().toString());
                values.put(SQLite_OpenHelper.CampoMateria4,MateriaC4.getText().toString());
                values.put(SQLite_OpenHelper.CampoMateria5,MateriaC5.getText().toString());

                db.update(SQLite_OpenHelper.TABLA_USUARIO,values,SQLite_OpenHelper.CampoNumero +"=?",parametros);
                Toast.makeText(getApplicationContext(),"Informacion Actualizada",Toast.LENGTH_LONG).show();
                db.close();
            }
        });



        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }

            private void consultar() {
                SQLiteDatabase db=conn.getReadableDatabase();
                String[] parametros={NumeroC.getText().toString()};
                String[] campos={"Nombre","Correo","Fecha","Materia1","Materia2","Materia3","Materia4","Materia5"};

                Cursor cursor =db.query(SQLite_OpenHelper.TABLA_USUARIO,campos,
                        SQLite_OpenHelper.CampoNumero+"=?",parametros,null,null,null);
                cursor.moveToFirst();

                try {
                    NombreC.setText(cursor.getString(0));
                    CorreoC.setText(cursor.getString(1));
                    FechaC.setText(cursor.getString(2));
                    MateriaC1.setText(cursor.getString(3));
                    MateriaC2.setText(cursor.getString(4));
                    MateriaC3.setText(cursor.getString(5));
                    MateriaC4.setText(cursor.getString(6));
                    MateriaC5.setText(cursor.getString(7));
                    cursor.close();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Usuario No existente",Toast.LENGTH_LONG).show();
                    limpiar();
                }
            }

            private void limpiar() {
                NumeroC.setText("");NombreC.setText("");CorreoC.setText("");FechaC.setText("");MateriaC1.setText("");
                MateriaC2.setText("");MateriaC3.setText("");MateriaC4.setText("");MateriaC5.setText("");
            }
        });

    }
}