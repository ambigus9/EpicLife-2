import java.util.ArrayList;

/**
 * Clase Game  maneja el flujo principal de la aplicación:
 * allí se crea la instancia del personaje del juego y se obtienen sus atributos. y se establecen
 * sus valores predeterminados.
 *
 * @author Henry Jiménez -Miguel Plazas
 * @version 09-11-16
 */

public class Game
{
    // Personaje principal del juego
    private Personaje personaje;
    // Lista que contiene los items del juego
    private ArrayList<Item> itemsDelJuego;
    // Lista que contiene los objetivos del juego
    private ArrayList<Objetivo> objetivosDelJuego;
    // Lista que contiene las misiones del juego
    private ArrayList<Mision> misionesDelJuego;
    // Lista que contiene las misiones del juego
    private ArrayList<Evento> eventosDelJuego;
    

    /**
    * Constructor for objects of class MenuPrincipal
    */
    public Game()
    {
        // initialise instance variables
       itemsDelJuego= new ArrayList<Item>();
       objetivosDelJuego= new ArrayList<Objetivo>();
       misionesDelJuego= new ArrayList<Mision>();
       eventosDelJuego= new ArrayList<Evento>();
       crearItems();
       crearObjetivos();  
       crearMisiones();
    }

    /**
    * Crea los items del juego
    */
    public void crearItems(){
        
       Arma nuevaArma = new Arma(1,"Espada de Hielo","Una espada que congela todo a su paso",100,2,1,0,100,"Agua");
       itemsDelJuego.add(nuevaArma);
       nuevaArma = new Arma(2,"Espada de Fuego","Quema al enemigo",75,1,3,2,80,"Fuego");
       itemsDelJuego.add(nuevaArma);
       nuevaArma = new Arma(3,"Espada de Aire","Desmiembra al enemigo",110,2,1,3,90,"Aire");
       itemsDelJuego.add(nuevaArma);
       Armadura nuevaArmadura = new Armadura(100,"Pechera de Hercules","Pechera portada por Hercules",45,6,4,0,"Pecho");
       itemsDelJuego.add(nuevaArmadura);
	   nuevaArmadura = new Armadura(101,"Casco de Hercules","Casco portado por Hercules",30,2,3,2,"Casco");       
       itemsDelJuego.add(nuevaArmadura);
	   nuevaArmadura = new Armadura(102,"Pantalones de Hercules","Pantalones portados por Hercules",30,4,2,0,"Pantalones");       
       itemsDelJuego.add(nuevaArmadura);      
       nuevaArmadura = new Armadura(103,"Pechera de Zeus","Pechera portada por Zeus",90,12,8,0,"Pecho");
       itemsDelJuego.add(nuevaArmadura);
	   nuevaArmadura = new Armadura(104,"Casco de Zeus","Casco portado por Zeus",60,4,6,4,"Casco");       
       itemsDelJuego.add(nuevaArmadura);
	   nuevaArmadura = new Armadura(105,"Pantalones de Zeus","Pantalones portados por Zeus",60,8,4,0,"Pantalones");       
       itemsDelJuego.add(nuevaArmadura);  

    }

    /**
    * Crea los objetivos del juego
    */
    public void crearObjetivos(){

    	Objetivo nuevoObjetivo = new Objetivo("Comer una manzana verde");
    	objetivosDelJuego.add(nuevoObjetivo);
        nuevoObjetivo = new Objetivo("Comer una manzana roja");
    	objetivosDelJuego.add(nuevoObjetivo);
        nuevoObjetivo = new Objetivo("Beber cafe sin azúcar");
    	objetivosDelJuego.add(nuevoObjetivo);
        nuevoObjetivo = new Objetivo("Beber chocolate sin azúcar");
    	objetivosDelJuego.add(nuevoObjetivo);
        nuevoObjetivo = new Objetivo("Comer pan integral");
    	objetivosDelJuego.add(nuevoObjetivo);
        nuevoObjetivo = new Objetivo("Beber juego de naranja");
    	objetivosDelJuego.add(nuevoObjetivo);
        nuevoObjetivo = new Objetivo("Comer huevo cocido");
    	objetivosDelJuego.add(nuevoObjetivo);
    }


    /**
    * Crea las misiones del juego
    */
    public void crearMisiones(){

    	Mision nuevaMision = new Mision("Manzanitis","Comer manzanas verdes o rojas diariamente",20,50,40,objetivosDelJuego,"Nutricion",10);
    	misionesDelJuego.add(nuevaMision);

       
    }

    /**
    * Crea los Eventos del juego
    */
    public void crearEventos(){
       
    }

}

