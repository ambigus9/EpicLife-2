
/**
 * Clase armadura, extiende de la clase items ya que todas las armaduras del juego 
 * son un item que puede comprarse y venderse, ademas de destruirse. 
 * 
 * @author Henry Jiménez -Miguel Plazas
 * @version 08-11-16
 */

public class Armadura extends Item
{
    // Parte del cuero para esta armadura.
    private String parteCuerpo;  

    /**
     * Constructor for objects of class Armadura
     * @param id Id del item.
     * @param nombre Nombre del item.
     * @param descripcion Descripcion del item.
     * @param costo Costo del item, en monedas de oro.
     * @param bonificacionSalud Es el valor que aumenta la salud del jugador con este item.
     * @param bonificacionAgilidad Es el valor que aumtenta la agilidad del jugador con este item.
     * @param bonificacionInteligencia Es el valor que aumenta la inteligencia del jugador con este item.
     * 
     */
    public Armadura(int id, String nombre,String descripcion,int costo,int bonificacionSalud,int bonificacionAgilidad,int bonificacionInteligencia,String parteCuerpo)
    {
        super(id,nombre,descripcion,costo,bonificacionSalud,bonificacionAgilidad,bonificacionInteligencia);
        this.parteCuerpo=parteCuerpo;
    }
    
     /**
     * Retorna lar parte del cuerpo en la cual se usa esta armadura
     * @return parteCuerpo Parte del cuerpo de la amardura
     */
    public String getParteCuerpo(){
       return parteCuerpo;
    }

}
