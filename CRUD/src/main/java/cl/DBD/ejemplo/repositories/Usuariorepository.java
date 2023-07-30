package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Usuario;

import java.util.List;
public interface Usuariorepository {
    /**
     * Inserta un nuevo usuario en la tabla usuario.
     * Dado que todos sus atributos son obligatorios (excepto código_usuario), si son nulos o están vacíos o si falla la conexión se producirá excepción.
     *
     * @param usuario objeto de la clase Usuario que tiene los atributos correspondientes para insertar como usuario.
     * @return devuelve un Usuario que contiene el usuario creado o null si se lanza una excepción.
     */


    public Usuario crear(Usuario usuario);

    /**
     * modifica los datos de un usuario en la tabla usuario.
     * Dado que todos sus atributos son obligatorios (excepto código_usuario), si son nulos o están vacíos, se producirá excepción
     * o si falla la conexión o si no se encuentra el código.
     *
     * @param usuario objeto de la clase Usuario que tiene los atributos correspondientes a insertar en un usuario
     * @param codigo_usuario int correspondiente al int del usuario cuyos datos se desea modificar.
     * @return devuelve una string que indica el éxito de la actualización de datos.
     * @throws Exception una excepción si uno de los atributos es null o está vacío, o si no se encuentra el código_usuario.
     */

    String update(Usuario usuario, int codigo_usuario);

    /** Lista todos los usuarios en la base de datos en orden ascendente por nombre.
     * * Si falla la conexión o si no se encuentra el código_usuario, se generará una excepción.
     *
     * @return devuelve una lista de Usuario que contiene los usuarios o null si se lanza una excepción.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Usuario> getAll();

    /**
     * Lista un usuario con un codigo_usuario especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_usuario se generara una excepción.
     *
     * @param codigo_usuario identificador de usuario a mostrar.
     * @return retorna una lista de Usuario que contiene los usuarios con el codigo_usuario solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_usuario.
     */

    public List<Usuario> show(int codigo_usuario);

    /**
     * Busca un usuario de la base de datos segun su codigo_usuario y lo elimina.
     * Si la conexion falla o si no encuentra el codigo_usuario se producirá excepción.
     *
     * @param codigo_usuario identificador del usuario que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */

    public void delete(int codigo_usuario);

}
