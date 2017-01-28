/**
* Clase Objetivo encargada de contener los parametros y el funcionamiento de un objetivo
* 
* @author Miguel Alberto Plazas Wadynski y Henry Andrés Jimenez Herrera
* @version 09-11-16
*/

public class Objetivo
{
    // El estado del objetivo, si el jugador ha completado el objetivo cambia a true.
    private boolean completado;
    // Descripción del objetivo
    private String descripcion;
    
    /**
    * @param estado Estado del objetivo, Por defecto false que significa que no se ha completado
    * @param descripcion Descripcion del objetivo
    **/
    public Objetivo (String descripcion) {
        this.descripcion = descripcion;
        completado=false;
    }

    /**
    * Retorna el estado del objetivo (True=Completado, False=No completado)
    * @return estado Estado del objetivo (True=Completado, False=No completado)
    */
    public boolean getCompletado(){
        return completado;
    }    

    /**
    * Marca como completado el objetivo
    */
    public void finalizarObjetivo(){
        completado = true;
        System.out.println("Objetivo completado");
    }
    
    /**
    * Retorna la descripcion del objetivo
    * @return descripcion Descripcion del objetivo
    */
    public String getDescripcion(){
        return descripcion;
    }   

}