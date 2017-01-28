/**
* Clase Mision  encargada de contener los aspectos de las misiones llevadas a 
* cabo por el jugador
* 
* @author Miguel Alberto Plazas Wadynski y Henry Andrés Jimenez Herrera
* @version 08-11-16
*/

import java.util.ArrayList; 

public class Mision
{
    // El estado de la mision, si el jugador ha aceptado la misión cambia a true porque esta activa.
    private boolean estado = false;
    // Nombre de la mision
    private String nombre;
    // Descripción de la mision
    private String descripcion;
    // monedas de oro que se consiguen al completar la mision
    private int monedas;
    // contiene los objetivos de la misión y si se han cumplido o no.
    private ArrayList<Objetivo> objetivos;
    // Factor de la salud asociado (Nutrición.Ejercicio físico.Descanso); solo puede tener un factor.
    private String factor;
    // Tiempo maximo para cumplir la mision.
    private int tiempo;

/**
* @param nombre Nombre de la misión
* @param descripcion Descripcion de la misión
* @param monedas Monedas de oro otorgadas por la misión
* @param factor Factor asociado a la Salud
* @param objetivos Objetivos de la misión, contiene nombre y si es o no completada
* @param tiempo Tiempo para cumplir la misión
**/
    public Mision (String nombre, String descripcion, int puntaje, int experiencia, int monedas,ArrayList<Objetivo> objetivos, String factor, int tiempo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monedas = monedas;
        this.objetivos = objetivos;
        this.factor = factor;
        this.tiempo = tiempo;
    }

    /**
    * Retorna el estado de la mision (True=Activa, False=No activa)
    * @return estado Estado de la mision (True=Activa, False=No activa)
    */
    public boolean getEstado(){
        return estado;
    }    

    /**
    * Configura el estado de la Mision
    * @argument Boolean estado Activa o Desactiva la mision.
    */
    public void setEstado (boolean estado){
        this.estado = estado;
    }

	/**
	* Retorna la lista de objetivos que componen la misión
	* @return Objetivos[] array de objetivos que componen la misión
	*/
    public ArrayList<Objetivo> crearObjetivo(){
        ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
        return objetivos;
    }

	/**
	* Marca como finalizada la misión y añade la experiencia y bonificación al
	* personaje
	*/
	public void finalizarMision(){
	}

}
