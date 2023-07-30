package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Calificacion_libro;

import java.util.List;

public interface Calificacion_librorepository {
    /**
     * Inserta una nuevo calificacion en la tabla calificacion_libro.
     * Al ser el todos sus atributos obligatorios (excepto codigo_calificacion), si son nulos o vacíos se lanzará
     * una excepción si la conexion falla .
     *
     * @param calificacion_libro objeto de la clase Calificacion_libro que tiene los atributos correspondientes a insertar como calificacion_libro.
     * @return retorna un Calificacion_libro que contiene la calificacion_libro creada o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Calificacion_libro crear(Calificacion_libro calificacion_libro);

    /**
     * Lista todos las calificaciones_libros de la base de datos de manera ascendente por valoracion.
     * Si la conexion falla lanzará excepción.
     *
     * @return retorna una lista de Calificacion_libro que contiene las calificaciones de libros o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     */

    String update(Calificacion_libro calificacion_libro, int codigo_calificacion_libro);

    /** Lista todos las calificacions_libros de la base de datos de manera ascendente por nombre.
     * * Si la conexion falla o si no encuentra el codigo_calificacion_libro se lanzará excepción.
     *
     * @return retorna una lista de Calificacion_libro que contiene las calificaciones de libros o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Calificacion_libro> getAll();

    /**
     * Lista un calificacion_libro con un codigo_calificacion_libro especifico de la base de datos.
     * Si la conexion falla o si no encuentra el id lanzará excepción.
     *
     * @param codigo_calificacion_libro codigo del libro que se desea mostrar.
     * @return retorna una lista de Calificacion_libro que contiene la calificacion_libro con el codigo_calificacion_libro solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_calificacion_libro.
     */

    public List<Calificacion_libro> show(int codigo_calificacion_libro);

    /**
     * Lista un libro con un precio menor a un valor especifico de la base de datos.
     * Si la conexion falla o si no encuentra el id lanzará excepción.
     *
     * @param valoracion maxima de los productos que se desea mostrar.
     * @return retorna una lista de Calificacion_libro que contiene los calificacion_libro/s con la valoracion menor al solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentran calificacion_libro con las caracteristicas mencionadas.
     */
    public List<Calificacion_libro> showLessThan(int valoracion);
    public List<Calificacion_libro> showMoreThan(int valoracion);
    /**
     * Elimina un libro de la base de datos por su codigo_calificacion_libro.
     * Si la conexion falla o si no encuentra el codigo_calificacion_libro lanzará excepción.
     *
     * @param codigo_calificacion_libro codigo de calificacion_libro que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_calificacion_libro.
     */
    public void delete(int codigo_calificacion_libro);
}
