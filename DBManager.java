package app.uis.epiclife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrador on 27/01/2017.
 */

public class DBManager {

    private DbHelper helper;
    public SQLiteDatabase db;

    public DBManager(Context context){
        helper= new DbHelper(context);
        db = helper.getWritableDatabase();
    }




    /**
     * Este metodo permite insertar Personajes principales en la base de datos
     *
     * @param Nombre Nombre que se le asigna al personaje
     * @param Genero Genero que se le asigna al personaje {Hombre-Mujer}
     * @param Edad  Edad inicial del personaje
     */
    public void insertarPersonaje(String Nombre,String Genero,String Edad){
        db.insert("personajes", null,generarContenedorPersonajeNuevo(Nombre,Genero,Edad));
    }



    /**
     * Este metodo genera un contenedor necesario para la insercion de la informacion en SQlite
     * los atributos que no se pasan tienen los valores por defecto
     * @param Nombre Nombre que se le asigna al personaje
     * @param Genero Genero que se le asigna al personaje {Hombre-Mujer}
     * @param Edad  Edad inicial del personaje
     */
    public ContentValues generarContenedorPersonajeNuevo(String Nombre, String Genero, String Edad){
        ContentValues contenedor= new ContentValues();
        contenedor.put(P_Nombre,Nombre);
        contenedor.put(P_Genero,Genero);
        contenedor.put(P_Edad,Edad);
        contenedor.put(P_Nivel_Salud,"100");
        contenedor.put(P_Nivel_Inteligencia,"100");
        contenedor.put(P_Nivel_Agilidad,"100");
        contenedor.put(P_Monedas,"0");
        contenedor.put(P_Nivel,"1");
        contenedor.put(P_live,"true");
        return contenedor;
    }

    /**
     * Este metodo genera un contenedor necesario para la insercion de la informacion en SQlite
     * los atributos que no se pasan tienen los valores por defecto
     * @param Nombre Nombre que se le asigna al personaje
     * @param Genero Genero que se le asigna al personaje {Hombre-Mujer}
     * @param Edad  Edad inicial del personaje
     */
    public ContentValues generarContenedorPersonaje(String Nombre,String Genero,String Edad,String Salud,String Inteligencia,String Agilidad,String Monedas,String Nivel,String Live){
        ContentValues contenedor= new ContentValues();
        contenedor.put(P_Nombre,Nombre);
        contenedor.put(P_Genero,Genero);
        contenedor.put(P_Edad,Edad);
        contenedor.put(P_Nivel_Salud,Salud);
        contenedor.put(P_Nivel_Inteligencia,Inteligencia);
        contenedor.put(P_Nivel_Agilidad,Agilidad);
        contenedor.put(P_Monedas,Monedas);
        contenedor.put(P_Nivel,Nivel);
        contenedor.put(P_live,Live);
        return contenedor;
    }




    /**
     * Permite cargar un cursos con la informacion de todos los Personajes
     */
    public Cursor cargarCursorPersonaje(){
        String [] columnas=new String []{P_Id,P_Nombre,P_Genero,P_Edad,P_Nivel_Salud,P_Nivel_Inteligencia,P_Nivel_Agilidad,P_Monedas,P_Nivel,P_live};
        return db.query("personajes", columnas, null, null, null, null, null);
    }



    /**
     * Este medodo permite Buscar un personaje en la base de datos
     * por el nombre.     *
     * @param Nombre Nombre que se le asigna al personaje
     */
    public Cursor buscarPersonajeNombre(String Nombre){
        String [] columnas=new String []{P_Id,P_Nombre,P_Genero,P_Edad,P_Nivel_Salud,P_Nivel_Inteligencia,P_Nivel_Agilidad,P_Monedas,P_Nivel,P_live};
        return db.query("personajes", columnas,P_Nombre+"=?",new String[]{Nombre}, null, null, null);
    }


    public void modificarPersonaje(String Nombre,String Genero,String Edad,String Salud,String Inteligencia,String Agilidad,String Monedas,String Nivel,String Live){
        db.update("usuarios", generarContenedorPersonaje(Nombre,Genero,Edad,Salud,Inteligencia,Agilidad,Monedas,Nivel,Live),P_Nombre+"=?",new String[]{Nombre});
    }



    //campos de la tabla Personaje
    public static final String P_Id="_id";
    public static final String P_Nombre="nombre";
    public static final String P_Genero="genero";
    public static final String P_Edad="edad";
    public static final String P_Nivel_Salud="salud";
    public static final String P_Nivel_Inteligencia="inteligencia";
    public static final String P_Nivel_Agilidad="agilidad";
    public static final String P_Monedas="monedas";
    public static final String P_Nivel="nivel";
    public static final String P_live="live";


    // Variables para la crearcion de tablas en la base de datos
    public static final String Crear_Tabla_Personaje="create table personajes ("
            +P_Id+" integer primary key autoincrement,"
            +P_Nombre+" text not null,"
            +P_Genero+" text not null,"
            +P_Edad+" text not null,"
            +P_Nivel_Salud+" text not null,"
            +P_Nivel_Inteligencia+" text not null,"
            +P_Nivel_Agilidad+" text not null,"
            +P_Monedas+" text not null,"
            +P_Nivel+" text not null,"
            +P_live+" text not null);";

    //campos de la tabla Evento
    public static final String E_Id="_id";
    public static final String E_Nombre="nombre";
    public static final String E_Descripcion="descripcion";
    public static final String E_Tipo="tipo";
    public static final Boolean E_Estado="estado";

}