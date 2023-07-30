package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Usuario_boleta;
import java.util.List;

public interface Usuario_boletarepository {


    /**
     * Inserta un nuevo usuario_boleta en la tabla usuario_boleta.
     * Dado que todos sus atributos son obligatorios (excepto codigo_usuario_boleta), si son nulos o están vacíos o si falla la conexion se producirá excepción.
     *
     * @param usuario_boleta objeto de la clase Usuario_boleta que tiene los atributos correspondientes a insertar como usuario_boleta.
     * @return retorna un Usuario_boleta que contiene el usuario_boleta creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Usuario_boleta crear(Usuario_boleta usuario_boleta);

    /**
     * Inserta datos en un usuario_boleta en la tabla usuario_boleta.
     * Al ser el todos sus atributos obligatorios (excepto codigo_usuario_boleta), si son nulos o vacíos se lanzará
     * una excepción, si la conexion falla o si no encuentra el codigo.
     *
     * @param usuario_boleta objeto de la clase Usuario_boleta que tiene los atributos correspondientes a insertar en un usuario_boleta.
     * @param codigo_usuario_boleta int correspondiente al codigo del usuario_boleta al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */

    String update(Usuario_boleta usuario_boleta, int codigo_usuario_boleta);

    /** Lista todos los usuario_boletas de la base de datos de manera ascendente por id_usuario.
     * * Si la conexion falla o si no encuentra el codigo_usuario_boleta se lanzará excepción.
     *
     * @return retorna una lista de Usuario_boleta que contiene los usuario_boletas o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Usuario_boleta> getAll();

    /**
     * Lista un usuario_boleta con un codigo_usuario_boleta especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_usuario_boleta lanzará excepción.
     *
     * @param codigo_usuario_boleta identificador del usuario_boleta que se desea mostrar.
     * @return retorna una lista de Usuario_boleta que contiene el usuario_boleta con el codigo_usuario_boleta solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_usuario_boleta.
     */

    public List<Usuario_boleta> show(int codigo_usuario_boleta);



    /**
     * Elimina un usuario_boleta de la base de datos por su codigo_usuario_boleta.
     * Si la conexion falla o si no encuentra el codigo_usuario_boleta lanzará excepción.
     *
     * @param codigo_usuario_boleta identificador del usuario_boleta que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */
    public void delete(int codigo_usuario_boleta);

}
