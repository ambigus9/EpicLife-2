import java.util.ArrayList;

/**
 * Clase Personaje contiene la información del personaje que representa al usuario en el 
 * videojuego.
 * 
 * @author Henry Jiménez -Miguel Plazas
 * @version 08-11-16
 */

public class Personaje
{
    //Atributos del personaje
    //Nombre del personaje
    private String nombre;
    //Representa el genero del presonaje, puede ser Hombre o Mujer.
    private String genero;
    // Edad del personaje
    private int edad;
    // Salud del personaje
    private int salud;
    // Agilidad del personaje
    private int agilidad;
    // Inteligencia del personaje
    private int inteligencia;
    // Cantidad de modeas de oro que posee el personaje
    private int monedas;
    // Nivel del personaje, Valores de 0 a 100 - para el primer prototipo se trabajara el nivel 1 unicamente.
    private int nivel;  
    // indica si el personaje esta vivo o muerto
    private boolean live;
    //Inventario del personaje
    private ArrayList<Item> inventario;
    //Eventos aceptados por el personaje
    private ArrayList<Evento> eventosPersonaje;
    
    //Unica instancia de la clase
    private static Personaje personaje;
    
    

    /**
     * Contructor del Personaje es privado ya que se implemento el patron de diseño singleton
     * para asegurar que solo pueda existir una instancia del personaje.
     * 
     * @param nombre Nombre que se le asigna al personaje
     * @param genero Genero que se le asigna al personaje {Hombre-Mujer}
     * @param edad  Edad inicial del personaje
     */
    private Personaje(String nombre, String genero, int edad)
    {
        this.nombre=nombre;
        this.genero=genero;
        this.edad=edad;
        salud=100;
        agilidad=10;
        inteligencia=10;
        monedas=0;
        nivel=1;
        live=true;
        inventario=new ArrayList<Item>();
        eventosPersonaje= new ArrayList<Evento>();
    }
    
    /**
     * Crea la unica instancia que se puede obtener del personaje. 
     * 
     * @param nombre Nombre que se le asigna al personaje
     * @param genero Genero que se le asigna al personaje {Hombre-Mujer}
     * @param edad  Edad inicial del personaje
     */
    public static Personaje getPersonajeInstance(String nombre, String genero, int edad){
        if(personaje==null){
            personaje=new Personaje(nombre,genero,edad);
        } else {
          System.out.println("Ya existe una instancia creada del personaje");
        }
        return personaje;

    }
    
    /**
    * Sobreescribimos el método clone, para que no se pueda clonar un objeto de esta clase
    * ya que implementamos singleton para garantizar que el personaje no se puede clonar
    */
    @Override
    public Personaje clone(){
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede clonar un objeto de la clase Personaje");
        }
        return null; 
    }
    
    

    /**
     * Monitorea las estadísticas actuales y dependiendo de las mismas
     * cambia el estado del personaje, retorna un arreglo String con dichas 
     * estadísticas y los cambios de estados si los hay
     * @return String  retorna un arreglo String con dichas  estadísticas y los cambios de * estados si los hay
     */
     public ArrayList<String> monitorearEstadisticas(){
         ArrayList<String> estadisticas = new ArrayList<String>();
         return    estadisticas;
     }


    /**
    * Añade un item al inventario del personaje
    * @param item Item que será añadidoal inventario del personaje
    */
    public void añadirItem(Item item){
        inventario.add(item);
    }

    /**
    * Elimina un item de la lista del inventario del personaje
    * @param idItem  Id del item que será eliminado del inventario del personaje
    */
    public void eliminarItem(int idItem){
       for(int i=0;i<=inventario.size();i++){
          if(inventario.get(i).getId()==idItem){
               inventario.remove(i);
          }
       }
    }

    /**
    * Retorna los items que se encuentran en el inventario del personaje
    * @return inventario Items que se encuentran en el inventario del personaje
    */
    public ArrayList<Item> getItems(){
        return inventario;    
    }
    
    /**
    * Obtiene el nombre del personaje
    * @return nombre Nombre del personaje
    */
    public String getNombre(){
        return nombre;
    }
    
    /**
    * Permite cambiar el nombre del personaje
    * @param nombre Nombre que se le va a asignar al personaje
    */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    /**
    * Obtiene el genero del personaje
    * @return genero Genero del personaje
    */
    public String getGenero(){
        return genero;
    }
    
    /**
    * Permite cambiar el genero del personaje
    * @param genero Genero que se le va a asignar al personaje
    */
    public void setGenero(String genero){
        this.genero=genero;
    }
    
    /**
    * Obtiene la edad del personaje
    * @return edad Edad del personaje
    */
    public int getEdad(){
        return edad;
    }
    
    /**
    * Permite cambiar la edad del personaje
    * @param edad Nueva edad del personaje
    */
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    /**
    * Obtiene la salud del personaje
    * @return salud Salud actual del personaje
    */
    public int getSalud() {
        return salud;
    }

    /**
    * Permite cambiar el valor de salud del personaje
    * @param salud Nivel de salud nueva del personaje
    */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
    * Obtiene la agilidad del personaje
    * @return agilidad Agilidad del personaje
    */
    public int getAgilidad() {
        return agilidad;
    }

    /**
    * Permite cambiar el valor de agilidad del personaje
    * @param agilidad Nivel de agilidad nueva del personaje
    */
    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    /**
    * Obtiene la inteligencia del personaje
    * @return inteligencia Iteligencia del personaje
    */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
    * Permite cambiar el valor de inteligencia del personaje
    * @param inteligencia Nivel de inteligencia nueva del personaje
    */
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
    * Obtiene las monedas del personaje
    * @return modeas Monedas del personaje
    */
    public int getMonedas() {
        return monedas;
    }

    /**
    * Permite cambiar el de las monedas del personaje
    * @param monedas Cantidad de monedas nuevas del personaje
    */
    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    /**
    * Obtiene el nivel del Personaje
    * @return nivel Nivel del personaje
    */
    public int getNivel() {
        return nivel;
    }

    /**
    * Permite cambiar el nivel del personaje
    * @param nivel Nuevo nivel del personaje
    */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
    * Indica si el personaje esta vivo
    * @return live Vida del personaje del personaje
    */
    public boolean isLive() {
        return live;
    }

    /**
    * Permite revivir o matar al personaje
    * @param live Estado nuevo para la vida del personaje.
    */
    public void setLive(boolean live) {
        this.live = live;
    }
}
