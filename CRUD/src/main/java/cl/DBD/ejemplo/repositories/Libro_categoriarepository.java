package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Libro_categoria;

import java.util.List;

public interface Libro_categoriarepository{
    /**
     * Inserta un nuevo libro_categoria en la tabla libro_categoria.
     * Dado que todos sus atributos son obligatorios (excepto codigo_libro_categoria), si son nulos o están vacíos o si falla la conexion se producirá excepción.
     *
     * @param libro_categoria objeto de la clase Libro_categoria que tiene los atributos correspondientes a insertar como libro_categoria.
     * @return retorna un Libro_categoria que contiene el libro_categoria creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Libro_categoria crear(Libro_categoria libro_categoria);

    /**
     * Inserta datos en un libro_categoria en la tabla libro_categoria.
     * Al ser el todos sus atributos obligatorios (excepto codigo_libro_categoria), si son nulos o vacíos se lanzará
     * una excepción, si la conexion falla o si no encuentra el codigo.
     *
     * @param libro_categoria objeto de la clase Libro_categoria que tiene los atributos correspondientes a insertar en un libro_categoria.
     * @param codigo_libro_categoria int correspondiente al codigo del libro_categoria al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */

    String update(Libro_categoria libro_categoria, int codigo_libro_categoria);

    /** Lista todos los libro_categoria de la base de datos de manera ascendente por codigo_libro_categoria.
     * * Si la conexion falla o si no encuentra el codigo_libro_categoria se lanzará excepción.
     *
     * @return retorna una lista de Libro_categoria que contiene los libro_categoria o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Libro_categoria> getAll();

    /**
     * Lista un libro_categoria con un codigo_libro_categoria especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_libro_categoria lanzará excepción.
     *
     * @param codigo_libro_categoria identificador del libro_categoria que se desea mostrar.
     * @return retorna una lista de Libro_categoria que contiene el libro_categoria con el codigo_libro_categoria solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_libro_categoria.
     */

    public List<Libro_categoria> show(int codigo_libro_categoria);



    /**
     * Elimina un libro_categoria de la base de datos por su codigo_libro_categoria.
     * Si la conexion falla o si no encuentra el codigo_libro_categoria lanzará excepción.
     *
     * @param codigo_libro_categoria identificador del libro_categoria que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */
    public void delete(int codigo_libro_categoria);

}
