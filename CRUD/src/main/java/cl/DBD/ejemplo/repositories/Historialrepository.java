package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Historial;

import java.util.List;



public interface Historialrepository {
    /**
     * @param historial objeto de la clase Historial que tiene los atributos correspondientes a insertar.
     * @return retorna un Historial que contiene el historial o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */
    public Historial crear(Historial historial);


    /**
     * @param historial objeto de la clase Historial que tiene los atributos correspondientes a insertar.
     * @param codigo_historial int correspondiente al historial al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */
    public String update(Historial historial, int codigo_historial);


    /** Lista todos los historiales de la base de datos de manera ascendente por codigo_historial.
     *
     * @return retorna una lista de historiales.
     * @throws Exception Si la conexion falla.
     */
    public List<Historial> getAll();


    /**
     * @param codigo_historial identificador del historial que se desea mostrar.
     * @return retorna una lista de historiales que contiene el codigo_boleta solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_carrito.
     */
    public List<Historial> show(int codigo_historial);


    /**
     * Elimina un Historial de la base de datos por su codigo_historial.
     * Si la conexion falla o si no encuentra el codigo_historial lanzará excepción.
     *
     * @param codigo_historial identificador del Historial que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_historial.
     */
    public void delete(int codigo_historial);

}
