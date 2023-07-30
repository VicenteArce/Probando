package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Libro_lista_favoritos;

import java.util.List;

public interface Libro_lista_favoritosrepository {

    /**
     *
     * Inserta un nuevo libro_lista_favoritos en la tabla Libro_lista_favoritos.
     * Dado que todos sus atributos son obligatorios (excepto código_lista_libro_favoritos), si son nulos o están vacíos o si falla la conexión se producirá excepción.
     *
     * @param libro_lista_favoritos objeto de la clase Libro_lista_favoritos que tiene los atributos correspondientes para insertar como libro_lista_favoritos.
     * @return devuelve un Libro_lista_favoritos que contiene el libro_lista_favoritos creado o null si se lanza una excepción.
     */


    public Libro_lista_favoritos crear(Libro_lista_favoritos libro_lista_favoritos);

    /**
     * modifica los datos de un libro_lista_favoritos en la tabla Libro_lista_favoritos.
     * Dado que todos sus atributos son obligatorios (excepto código_libro_lista_favoritos), si son nulos o vacíos , o si la conexion falla o si no encuentra el codigo.
     * se lanzará una excepción
     *
     * @param codigo_lista_libro_favoritos int correspondiente al codigo del libro_lista_favoritos cuyos datos se desea modificar.
     * @return devuelve una string que indica el éxito de la actualización de datos.
     * @throws Exception una excepción si uno de los atributos es null o está vacío, o si no se encuentra el código_libro_lista_favoritos.
     */

    String update(Libro_lista_favoritos libro_lista_favoritos, int codigo_lista_libro_favoritos);

    /** Lista todos los libro_lista_favoritos en la base de datos en orden ascendente por codigo_usuario.
     * * Si falla la conexión o si no se encuentra el código_libro_lista_favoritos, se generará una excepción.
     *
     * @return devuelve una lista de Libro_lista_favoritos que contiene los libro_lista_favoritos o null si se lanza una excepción.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Libro_lista_favoritos> getAll();

    /**
     * Lista un libro_lista_favoritos con un codigo_lista_libro_favoritos de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_lista_libro_favoritos se generara una excepción.
     *
     * @param codigo_lista_libro_favoritos identificador de libro_lista_favoritos a mostrar.
     * @return retorna una lista de Libro_lista_favoritos que contiene los libro_lista_favoritos con el codigo_lista_libro_favoritos solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_lista_libro_favoritos.
     */

    public List<Libro_lista_favoritos> show(int codigo_lista_libro_favoritos);

    /**
     * Busca un libro_lista_favoritos de la base de datos segun su codigo_lista_libro_favoritos y lo elimina.
     * Si la conexion falla o si no encuentra el codigo_lista_libro_favoritos se producirá excepción.
     *
     * @param codigo_lista_libro_favoritos identificador del libro_lista_favoritos que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_lista_libro_favoritos.
     */

    public void delete(int codigo_lista_libro_favoritos);


}
