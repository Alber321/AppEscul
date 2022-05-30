package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    public static final String TABLA_USUARIO="usuarios";
    public static final String CampoNumero="NumeroUsuario";
    public static final String CampoNombre="Nombre";
    public static final String CampoCorreo="Correo";
    public static final String CampoFecha="Fecha";
    public static final String CampoMateria1="Materia1";
    public static final String CampoMateria2="Materia2";
    public static final String CampoMateria3="Materia3";
    public static final String CampoMateria4="Materia4";
    public static final String CampoMateria5="Materia5";

    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(_ID integer primary key autoincrement, Nombre text, NumeroUsuario text, Correo text, Fecha text, Contraseña text, " +
                "Materia1 text, Materia2 text, Materia3 text, Materia4 text, Materia5 text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //Abrir BD
    public void abrir(){
        this.getWritableDatabase();
    }
    //Cerrar BD
    public void cerrar(){
        this.close();
    }

    //Insertar Registros en la tabla de usuarios
    public void insertarReg(String nom, String num, String correo, String fecha, String contra,
                            String mat1, String mat2, String mat3, String mat4, String mat5){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nom);
        valores.put("NumeroUsuario",num);
        valores.put("Correo",correo);
        valores.put("Fecha",fecha);
        valores.put("Contraseña",contra);
        valores.put("Materia1",mat1);
        valores.put("Materia2",mat2);
        valores.put("Materia3",mat3);
        valores.put("Materia4",mat4);
        valores.put("Materia5",mat5);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    //Metodo que permite validar usuario existente
    public Cursor ConsultarUsuPas(String num, String contra) throws SecurityException{
        Cursor mcursor=null;
         mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","NumeroUsuario","Correo","Fecha"
         ,"Contraseña","Materia1","Materia2","Materia3","Materia4","Materia5"},
                 "NumeroUsuario like '"+num+"' and Contraseña like '"+contra+"'",null,null,null,null);
        return mcursor;
    }


}
