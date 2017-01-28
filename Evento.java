
/**
* Clase Evento  encargada de manejar las propiedades de los eventos y las
* instancias de los mismos cada evento cuenta con una lista de misiones en
* particular, un nombre y una descripción.
 * 
 * @author Miguel Alberto Plazas Wadynski y Henry Andrés Jimenez Herrera
 * @version 2016/12/08
 */
import java.util.ArrayList; 

public class Evento
{
    
    //Nombre del evento
    private String nombre;
    // Descripcion del evento
    private String descripcion;
    // Lista de misiones del evento
    private ArrayList<Mision> misiones;
    // Tipo de evento
    private Enum tipo;
    // Indica si el evento ha sido completado (True, evento completado, false evento incompleto). 
    private Boolean estado;
    private ArrayList<String> resultados;

/**
* @param nombre Nombre del evento
* @param descripcion Descripcion del evento
* @param lista de Misiones Lista de misiones del evento
* @param tipo Tipo de evento: Batalla, Entrenamiento o Investigación
**/
    public Evento (String nombre, String descripcion, ArrayList<Mision> misiones, Enum tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.misiones = misiones;
        this.tipo = tipo;
        estado=false;
    }

    public enum tipo {
    BATALLA, ENTRENAMIENTO, INVESTIGACION 
    }

    /**
    * Crea una lista de misiones para el evento
    * @return ArrayList<Mision> retorna lista vacia de misiones del evento.
    */
    public ArrayList<Mision> crearMisiones(){
        ArrayList<Mision> misiones = new ArrayList<Mision>();
        return misiones;
    }

    /**
    * Retorna la lista de misiones que componen el evento
    * @return misiones retorna lista de misiones del evento.
    */
    public ArrayList<Mision> getMisiones(){
        return misiones;
    }    

    /**
    * Añade misiones a la lista de misiones del evento
    * @argument ArrayList<Mision> misiones Añade lista de misiones al evento.
    */
    public void setMisiones (ArrayList<Mision> misiones){
        this.misiones = misiones;
    }

    /**
    * Marca una misión del evento como activa cuando el usuario la acepta
    * @argument  Mision  marca la misión de la lista de misiones del evento como activa.
    */
    public void activarMision(Mision mision)
    {
        // Mision.setEstado = true;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado (boolean estado){
        this.estado = estado;
    }

    /**
    * Finaliza el evento y genera resumen de resultados
    * @return  String[] resultados de la finalización del evento
    */
    public ArrayList<String> finEvento()
    {
        resultados.add("Estadisticas");
        return resultados;
    }

}