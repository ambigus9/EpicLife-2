package app.uis.epiclife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
     * @param personaje instancia del personaje que sera almacenado en la base de datos
     */
    public void insertarPersonaje(Personaje personaje){
        db.insert("personajes", null,generarContenedorPersonaje(personaje));
    }


    /**
     * Este metodo permite insertar Armas en la base de datos
     */
    public void insertarArmas(){
        db.insert("armas", null,generarContenedorArma(new Arma(1,
                "Espada de Madera",
                "Apenas te puedes defender con ella",
                R.drawable.armainicial_icono,
                R.drawable.armainicial,
                0,
                0,
                0,
                0,
                10,
                "madera"),"true"));
        db.insert("armas", null,generarContenedorArma(new Arma(2,
                "Espada de Bronce",
                "Espada para novatos",
                R.drawable.espada_bronce_icono,
                R.drawable.espada_bronce,
                10,
                10,
                10,
                10,
                20,
                "metal"),"false"));
    }

    /**
     * Este metodo permite insertar Armas en la base de datos
     */
    public void insertarArmaduras(){
        db.insert("armaduras", null,generarContenedorArmadura(new Armadura(1,
                "Armadura Bronce",
                "Armadura básica para luchar contra los malos habitos",
                R.drawable.bronce_icono,
                R.drawable.bronce,
                10,1,1,1),"true"));
        db.insert("armaduras", null,generarContenedorArmadura(new Armadura(1,
                "Armadura Hierro",
                "Armadura Fuerte para luchar contra los malos habitos",
                R.drawable.hierro_icono,
                R.drawable.hierro,
                10,3,3,3),"false"));
    }







    /**
     * Permite cargar una instancia del personaje
     */
    public Personaje cargarPersonaje(){
        Personaje personaje= Personaje.getPersonajeInstance();
        Cursor cursor;
        String [] columnas=new String []{P_Id,P_Nombre,P_Genero,P_Edad,P_Nivel_Salud,P_Nivel_Inteligencia,P_Nivel_Agilidad,P_Monedas,P_Nivel,P_live};
        cursor= db.query("personajes", columnas, null, null, null, null, null);
        if(cursor.moveToLast()){
            personaje.setNombre(cursor.getString(1));
            personaje.setGenero(cursor.getString(2));
            personaje.setEdad(cursor.getInt(3));
            personaje.setSalud(cursor.getInt(4));
            personaje.setInteligencia(cursor.getInt(5));
            personaje.setAgilidad(cursor.getInt(6));
            personaje.addMonedas(cursor.getInt(7));
            personaje.setNivel(cursor.getInt(8));
            personaje.setLive(Boolean.getBoolean(cursor.getString(9)));
        }

        personaje.setItems(cargarItemsInventario());
        return personaje;
    }


    public ArrayList<Item> cargarItemsTienda(){

        ArrayList<Item> itemsTienda = new ArrayList();
        Cursor cursor;
        String [] columnasArmas= new String []{W_Id,W_Nombre,W_Descripcion,W_icono,W_imagen,W_Costo,W_Bonus_Salud,W_Bonus_Inteligencia,W_Bonus_Agilidad,W_dano,W_Elemento,W_comprada};
        cursor = db.query("armas", columnasArmas,W_comprada+"=?",new String[]{"false"}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                itemsTienda.add(new Arma(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getInt(8),
                        cursor.getInt(9),
                        cursor.getString(10)));
            } while(cursor.moveToNext());
        }

        String [] columnasArmaduras= new String []{A_Id,A_Nombre,A_Descripcion,A_icono,A_imagen,A_Costo,A_Bonus_Salud,A_Bonus_Inteligencia,A_Bonus_Agilidad};
        cursor = db.query("armaduras", columnasArmaduras,A_comprada+"=?",new String[]{"false"}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                itemsTienda.add(new Armadura(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getInt(8)));
            } while(cursor.moveToNext());
        }

        return itemsTienda;

    }

    public ArrayList<Item> cargarItemsInventario(){

        ArrayList<Item> itemsTienda = new ArrayList();
        Cursor cursor;
        String [] columnasArmas= new String []{W_Id,W_Nombre,W_Descripcion,W_icono,W_imagen,W_Costo,W_Bonus_Salud,W_Bonus_Inteligencia,W_Bonus_Agilidad,W_dano,W_Elemento,W_comprada};
        cursor = db.query("armas", columnasArmas,W_comprada+"=?",new String[]{"true"}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                itemsTienda.add(new Arma(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getInt(8),
                        cursor.getInt(9),
                        cursor.getString(10)));
            } while(cursor.moveToNext());
        }

        String [] columnasArmaduras= new String []{A_Id,A_Nombre,A_Descripcion,A_icono,A_imagen,A_Costo,A_Bonus_Salud,A_Bonus_Inteligencia,A_Bonus_Agilidad};
        cursor = db.query("armaduras", columnasArmaduras,A_comprada+"=?",new String[]{"true"}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                itemsTienda.add(new Armadura(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getInt(8)));
            } while(cursor.moveToNext());
        }

        return itemsTienda;

    }



    /**
     * Este medodo permite Buscar un personaje en la base de datos
     * por el nombre.     *
     * @param personaje Instancia del personaje que contiene la informacion que se desea almacenar
     */
    public Cursor buscarPersonajeNombre(Personaje personaje){
        String [] columnas=new String []{P_Id,P_Nombre,P_Genero,P_Edad,P_Nivel_Salud,P_Nivel_Inteligencia,P_Nivel_Agilidad,P_Monedas,P_Nivel,P_live};
        return db.query("personajes", columnas,P_Nombre+"=?",new String[]{personaje.getNombre()}, null, null, null);
    }


    public void modificarPersonaje(Personaje personaje){
        db.update("personajes", generarContenedorPersonaje(personaje),P_Nombre+"=?",new String[]{personaje.getNombre()});
    }


    /**
     * Este metodo genera un contenedor necesario para la insercion de la informacion en SQlite
     * @param personaje instancia del personaje sobre el cual se desea crear el contenedor
     */
    public ContentValues generarContenedorPersonaje(Personaje personaje){
        ContentValues contenedor= new ContentValues();
        contenedor.put(P_Nombre,personaje.getNombre());
        contenedor.put(P_Genero,personaje.getGenero());
        contenedor.put(P_Edad,personaje.getEdad());
        contenedor.put(P_Nivel_Salud,personaje.getSalud());
        contenedor.put(P_Nivel_Inteligencia,personaje.getInteligencia());
        contenedor.put(P_Nivel_Agilidad,personaje.getAgilidad());
        contenedor.put(P_Monedas,personaje.getMonedas());
        contenedor.put(P_Nivel,personaje.getNivel());
        contenedor.put(P_live,String.valueOf(personaje.isLive()));
        return contenedor;
    }

    /**
     * Este metodo genera un contenedor necesario para la insersion de la informacion en SQlite
     * @param arma instancia del arma de la cual se obtiene el contenedor
     */
    public ContentValues generarContenedorArma(Arma arma,String comprada){
        ContentValues contenedor= new ContentValues();
        contenedor.put(W_Id,arma.getId());
        contenedor.put(W_Nombre,arma.getNombre());
        contenedor.put(W_Descripcion,arma.getDescripcion());
        contenedor.put(W_icono,arma.getIcono());
        contenedor.put(W_imagen,arma.getImagen());
        contenedor.put(W_Costo,arma.getCosto());
        contenedor.put(W_Bonus_Salud,arma.getBonificacionSalud());
        contenedor.put(W_Bonus_Inteligencia,arma.getbonificacionInteligencia());
        contenedor.put(W_Bonus_Agilidad,arma.getBonificacionAgilidad());
        contenedor.put(W_dano,arma.getDaño());
        contenedor.put(W_Elemento,arma.getElemento());
        contenedor.put(W_comprada,comprada);
        return contenedor;
    }

    /**
     * Este metodo genera un contenedor necesario para la insersion de la informacion en SQlite
     * @param armadura instancia de la armadura que se desea almacenar
     */
    public ContentValues generarContenedorArmadura(Armadura armadura, String comprada){
        ContentValues contenedor= new ContentValues();
        contenedor.put(A_Id,armadura.getId());
        contenedor.put(A_Nombre,armadura.getNombre());
        contenedor.put(A_Descripcion,armadura.getDescripcion());
        contenedor.put(A_icono,armadura.getIcono());
        contenedor.put(A_imagen,armadura.getImagen());
        contenedor.put(A_Costo,armadura.getCosto());
        contenedor.put(A_Bonus_Salud,armadura.getBonificacionSalud());
        contenedor.put(A_Bonus_Inteligencia,armadura.getbonificacionInteligencia());
        contenedor.put(A_Bonus_Agilidad,armadura.getBonificacionAgilidad());
        contenedor.put(A_comprada,comprada);
        return contenedor;
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

    //campos de la tabla Armas
    public static final String W_Id="_id";
    public static final String W_Nombre="nombre";
    public static final String W_Descripcion="descripcion";
    public static final String W_icono="icono";
    public static final String W_imagen="imagen";
    public static final String W_Costo="costo";
    public static final String W_Bonus_Salud="salud";
    public static final String W_Bonus_Inteligencia="inteligencia";
    public static final String W_Bonus_Agilidad="agilidad";
    public static final String W_dano="dano";
    public static final String W_Elemento="elemento";
    public static final String W_comprada="comprada";

    //campos de la tabla Armaduras
    public static final String A_Id="_id";
    public static final String A_Nombre="nombre";
    public static final String A_Descripcion="descripcion";
    public static final String A_icono="icono";
    public static final String A_imagen="imagen";
    public static final String A_Costo="costo";
    public static final String A_Bonus_Salud="salud";
    public static final String A_Bonus_Inteligencia="inteligencia";
    public static final String A_Bonus_Agilidad="agilidad";
    public static final String A_comprada="comprada";


    //campos de la tabla Misiones
    public static final String M_Id="_id";
    public static final String M_Nombre="nombre";
    public static final String M_Descripcion="descripcion";
    public static final String M_icono="icono";
    public static final String M_imagen="imagen";
    public static final String M_Monedas="monedas";
    public static final String M_Factor="factor";
    public static final String M_Tiempo="tiempo";

    //campos de la tabla Objetivos
    public static final String O_Id="_id";
    public static final String O_Descripcion="descripcion";
    public static final String O_Estado="estado";



    // Variables para la creacion de tablas en la base de datos

    //sentencia SQL para crear la estructura de la tabla personaje
    public static final String Crear_Tabla_Personaje="create table personajes ("
            +P_Id+" integer primary key autoincrement,"
            +P_Nombre+" text not null,"
            +P_Genero+" text not null,"
            +P_Edad+" integer not null,"
            +P_Nivel_Salud+" integer not null,"
            +P_Nivel_Inteligencia+" integer not null,"
            +P_Nivel_Agilidad+" integer not null,"
            +P_Monedas+" integer not null,"
            +P_Nivel+" integer not null,"
            +P_live+" text not null);";

    // Sentencia SQL para crear la estructura de la tabla arma
    public static final String Crear_Tabla_Arma="create table armas ("
            +W_Id+" integer primary key,"
            +W_Nombre+" text not null,"
            +W_Descripcion+" text not null,"
            +W_icono+" integer not null,"
            +W_imagen+" integer not null,"
            +W_Costo+" integer not null,"
            +W_Bonus_Salud+" integer not null,"
            +W_Bonus_Inteligencia+" integer not null,"
            +W_Bonus_Agilidad+" integer not null,"
            +W_dano+" integer not null,"
            +W_Elemento+" text not null,"
            +W_comprada+" text not null);";

    // Sentencia SQL para crear la estructura de la tabla armadura
    public static final String Crear_Tabla_Armadura="create table armaduras ("
            +A_Id+" integer primary key,"
            +A_Nombre+" text not null,"
            +A_Descripcion+" text not null,"
            +A_icono+" integer not null,"
            +A_imagen+" integer not null,"
            +A_Costo+" text not null,"
            +A_Bonus_Salud+" text not null,"
            +A_Bonus_Inteligencia+" text not null,"
            +A_Bonus_Agilidad+" text not null,"
            +A_comprada+" text not null);";




}
