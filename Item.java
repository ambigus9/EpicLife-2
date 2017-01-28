
/**
 * Clase Item, esta clase contiene los atributos que poseen todos los items
 * del juego
 *
 * @author Henry Jiménez -Miguel Plazas
 * @version 08-11-16
 */


public abstract class Item
{
    //identificador unico del Item
    private int id;
    //Nombre del Item
    private String nombre;
    //Descripción del Item
    private String descripcion;
    // Costo en monedas de oro del item
    private int costo;
    // Bonificacion de salud del item, siempre debe ser positivo
    private int bonificacionSalud;
    // Bonificación en agilidad del item, siempre debe ser positivo
    private int bonificacionAgilidad;
    // Bonificación de Inteligencia del item, siempre debe ser positivo
    private int bonificacionInteligencia;

    /**
     * Contructor del Item
     * 
     * @param id Id del item.
     * @param nombre Nombre del item.
     * @param descripcion Descripcion del item.
     * @param costo Costo del item, en monedas de oro.
     * @param bonificacionSalud Es el valor que aumenta la salud del jugador con este item.
     * @param bonificacionAgilidad Es el valor que aumtenta la agilidad del jugador con este item.
     * @param bonificacionInteligencia Es el valor que aumenta la inteligencia del jugador con este item.
     * 
     */
    public Item(int id, String nombre,String descripcion,int costo,int bonificacionSalud,int bonificacionAgilidad,int bonificacionInteligencia)
    {
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion; 
        this.costo=costo;
        this.bonificacionSalud=bonificacionSalud;
        this.bonificacionAgilidad=bonificacionAgilidad;
        this.bonificacionInteligencia=bonificacionInteligencia;
    }
    
    /**
     * Retorna el id del item, este id es un numero unico que se le asigna a cada item del juego
     * 
     * @return id Id del item.
     */
    public int getId(){
       return id;
    }
    
    /**
     * Retorna el nombre del item
     * @return nombre Nombre del item.
     */
    public String getNombre(){
       return nombre;
    }
    
    /**
     * Retorna la descripción del item
     * @return descripcion Descripcion del item. 
     */
    public String getDescripcion(){
       return descripcion;
    }
    
    /**
     * Retorna el costo del item
     * @return costo Costo del item
     */
    public int getCosto(){
       return costo;
    }
    
    /**
     * Retorna la bonificacion de salud del item
     * @return bonificacionSalud Bonificacion de salud del item.
     */
    public int getBonificacionSalud(){
       return bonificacionSalud;
    }
    
    /**
     * Retorna la bonificacion de Agilidad del item
     * @return bonificacionAgilidad Bonificacion de Agilidad del item.
     */
    public int getBonificacionAgilidad(){
       return bonificacionAgilidad;
    }
    
    /**
     * Retorna la bonificacion de Inteligencia del item
     * @return bonificacionInteligencia Bonificacion de Inteligencia del item.
     */
    public int bonificacionInteligencia(){
       return bonificacionInteligencia;
    }
    
}
