
/**
 * Clase arma, extiende de la clase items ya que todas las armas del juego 
 * son un item que puede comprarse y venderse, ademas de destruirse. 
 * 
 * @author Henry Jiménez -Miguel Plazas
 * @version 08-11-16
 */

public class Arma extends Item
{
    // daño del arma
    private int daño;
    // elemento del arma
    private String elemento;      
    

    /**
     * Constructor for objects of class Arma
     * @param id Id del arma.
     * @param nombre Nombre del arma.
     * @param descripcion Descripcion del arma.
     * @param costo Costo del item, en monedas de oro.
     * @param bonificacionSalud Es el valor que aumenta la salud del jugador con esta arma.
     * @param bonificacionAgilidad Es el valor que aumtenta la agilidad del jugador con esta arma.
     * @param bonificacionInteligencia Es el valor que aumenta la inteligencia del jugador con esta arma.
     * @param daño Daño del arma.
     * @param elemento Elemento del arma.
     * 
     */
    public Arma(int id, String nombre,String descripcion,int costo,int bonificacionSalud,int bonificacionAgilidad,int bonificacionInteligencia,int daño,String elemento)
    {
        super(id,nombre,descripcion,costo,bonificacionSalud,bonificacionAgilidad,bonificacionInteligencia);
        this.daño=daño;
        this.elemento=elemento;        
    }
    
    /**
     * Retorna el daño del arma
     * @return daño Daño del arma
     */
    public int getDaño(){
       return daño;
    }
    
     /**
     * Retorna el elemento al cual pertence el arma
     * @return elemento Elemento del arma.
     */
    public String getElemento(){
       return elemento;
    }
    
}
