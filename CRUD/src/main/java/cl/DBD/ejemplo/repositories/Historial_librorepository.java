package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Historial_libro;

import java.util.List;


public interface Historial_librorepository {
    /**
     * @param historial_libro objeto de la clase Historial_libro que tiene los atributos correspondientes a insertar.
     * @return retorna un Historial_libro que contiene el historial_libro creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */
    public Historial_libro crear(Historial_libro historial_libro);


    /**
     * @param historial_libro objeto de la clase Historial libro que tiene los atributos correspondientes a insertar.
     * @param codigo_historial_libro int correspondiente al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */
    public String update(Historial_libro historial_libro, int codigo_historial_libro);


    /** Lista todos los historiales_libro de la base de datos de manera ascendente por codigo_historial_libro.
     * Si la conexion falla o si no encuentra el codigo_historial_libro se lanzará excepción.
     *
     * @return retorna una lista de historial_libro que contiene los codigo_historial_libro o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     */
    public List<Historial_libro> getAll();


    /**
     * Lista un historial_libro con un codigo_historial_libro especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo lanzará excepción.
     *
     * @param codigo_historial_libro identificador del historial_libro que se desea mostrar.
     * @return retorna una lista de historial_libro con el codigo_boleta solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_boleta.
     */
    public List<Historial_libro> show(int codigo_historial_libro);

    /**
     * Elimina un historial_libro de la base de datos por su codigo_historial_libro.
     * Si la conexion falla o si no encuentra el codigo_historial_libro lanzará excepción.
     *
     * @param codigo_historial_libro identificador del historial_libro que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */
    public void delete(int codigo_historial_libro);
}
