package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Libro;

import java.util.List;
public interface Librorepository {
    /**
     * Inserta un nuevo libro en la tabla libro.
     * Dado que todos sus atributos son obligatorios (excepto id_libro), si son nulos o están vacíos o si falla la conexion se producirá excepción.
     *
     * @param libro objeto de la clase Libro que tiene los atributos correspondientes a insertar como libro.
     * @return retorna un Libro que contiene el libro creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Libro crear(Libro libro);

     /**
     * inserta datos de un libro en la tabla libro.
     * Dado que todos sus atributos son obligatorios (excepto id_libro), si son nulos o están vacíos, se producirá excepción
     * o si falla la conexión o si no se encuentra el id.
     *
     * @param libro objeto de la clase Libro que tiene los atributos correspondientes a insertar en un libro
     * @param id_libro int correspondiente al int del libro cuyos datos se desea modificar.
     * @return devuelve una string que indica el éxito de la actualización de datos.
     * @throws Exception una excepción si uno de los atributos es null o está vacío, o si no se encuentra el id.
     */

    String update(Libro libro, int id_libro);

    /** Lista todos los libros de la base de datos de manera ascendente por nombre.
     * * Si la conexion falla o si no encuentra el id_libro se lanzará excepción.
     *
     * @return retorna una lista de Libro que contiene los libros o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Libro> getAll();

    /**
     * Lista un producto con un id especifico de la base de datos.
     * Si la conexion falla o si no encuentra el id lanzará excepción.
     *
     * @param id_libro identificador del libro que se desea mostrar.
     * @return retorna una lista de Libro que contiene el libro con el id_libro solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el id.
     */

    public List<Libro> show(int id_libro);

    /**
     * Lista un libro con un precio menor a un valor especifico de la base de datos.
     * Si la conexion falla o si no encuentra el id lanzará excepción.
     *
     * @param precio maximo de los productos que se desea mostrar.
     * @return retorna una lista de Libro que contiene el/los libro/s con el precio menor al solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentran libros con las caracteristicas mencionadas.
     */
    public List<Libro> showLessThan(int precio);

    /**
     * Elimina un libro de la base de datos por su id.
     * Si la conexion falla o si no encuentra el id lanzará excepción.
     *
     * @param id_libro identificador del libro que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el id.
     */
    public void delete(int id_libro);

}