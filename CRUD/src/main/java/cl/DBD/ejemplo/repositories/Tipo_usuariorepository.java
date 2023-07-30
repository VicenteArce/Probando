package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Tipo_usuario;

import java.util.List;
public interface Tipo_usuariorepository {
    /**
     * Inserta un nuevo tipo_usuario en la tabla tipo_usuario.
     * Al ser el todos sus atributos obligatorios (excepto codigo), si son nulos o vacíos se lanzará o si la conexion falla
     * se producira una excepcion  .
     *
     * @param tipo_usuario objeto de la clase Tipo_usuario que tiene los atributos correspondientes a insertar como tipo_usuario.
     * @return retorna un Tipo_usuario que contiene el tipo_usuario creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Tipo_usuario crear(Tipo_usuario tipo_usuario);

    /**
     * modifica datos en un tipo_usuario en la tabla tipo_usuario.
     * Al ser todos sus atributos obligatorios (excepto codigo_tipo_usuario), si son nulos o vacíos se lanzará
     * una excepción, si la conexion falla o si no encuentra el codigo.
     * @param tipo_usuario objeto de la clase Tipo_usuario que tiene los atributos correspondientes a insertar en un tipo_usuario
     * @param codigo_tipo_usuario int correspondiente al int del tipo de usuario al cual se desea modificar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */

    String update(Tipo_usuario tipo_usuario, int codigo_tipo_usuario);



    /** Lista todos los tipo_usuarios de la base de datos de manera ascendente por nombre.
     * * Si la conexion falla o si no encuentra el codigo_tipo_usuario se lanzará excepción.
     *
     * @return retorna una lista de Tipo_usuario que contiene los tipo_usuario o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Tipo_usuario> getAll();

    /**
     * Lista un tipo_usuario con un codigo_tipo_usuario especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_tipo_usuario lanzará excepción.
     *
     * @param codigo_tipo_usuario identificador del usuario que se desea mostrar.
     * @return retorna una lista de Tipo_usuario que contiene el tipo_usuario con el codigo_tipo_usuario solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_tipo_usuario.
     */

    public List<Tipo_usuario> show(int codigo_tipo_usuario);

    /**
     * Elimina un tipo_usuario de la base de datos por su codigo_tipo_usuario.
     * Si la conexion falla o si no encuentra el codigo_tipo_usuario lanzará excepción.
     *
     * @param codigo_tipo_usuario identificador del tipo_usuario que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el id.
     */

    public void delete(int codigo_tipo_usuario);
}
