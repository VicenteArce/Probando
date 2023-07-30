package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Agrega_libro_transaccion;
import java.util.List;

public interface Agrega_libro_transaccionrepository {

    /**
     * Inserta un nuevo agrega_libro_transaccion en la tabla agrega_libro_transaccion.
     * Dado que todos sus atributos son obligatorios (excepto codigo_agrega_libro_transaccion), si son nulos o están vacíos o si falla la conexion se producirá excepción.
     *
     * @param agrega_libro_transaccion objeto de la clase Agrega_libro_transaccion que tiene los atributos correspondientes a insertar como agrega_libro_transaccion.
     * @return retorna un Agrega_libro_transaccion que contiene el agrega_libro_transaccion creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Agrega_libro_transaccion crear(Agrega_libro_transaccion agrega_libro_transaccion);

    /**
     * Inserta datos en un agrega_libro_transaccion en la tabla Agrega_libro_transaccion.
     * Al ser el todos sus atributos obligatorios (excepto codigo_agregar_libro_transaccion), si son nulos o vacíos se lanzará
     * una excepción, si la conexion falla o si no encuentra el serial_alt.
     *
     * @param agrega_libro_transaccion objeto de la clase Agregar_libro_transaccion que tiene los atributos correspondientes a insertar en un agregar_libro_transaccion.
     * @param serial_alt int correspondiente al codigo del agrega_libro_transaccion al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el serial_alt.
     */

    public String update(Agrega_libro_transaccion agrega_libro_transaccion, int codigo_agregar_libro);

    /** Lista todos los agrega_libro_transaccion de la base de datos de manera ascendente por serial_alt.
     * * Si la conexion falla o si no encuentra el serial_alt se lanzará excepción.
     *
     * @return retorna una lista de Agrega_libro_transaccion que contiene los agrega_libro_transaccion o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Agrega_libro_transaccion> getAll();

    /**
     * Lista un agrega_libro_transaccion con un serial_alt especifico de la base de datos.
     * Si la conexion falla o si no encuentra el serial_alt lanzará excepción.
     *
     * @param serial_alt identificador del agrega_libro_transaccion que se desea mostrar.
     * @return retorna una lista de Agrega_libro_transaccion que contiene el agrega_libro_transaccion con el serial_alt solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el serial_alt.
     */

    public List<Agrega_libro_transaccion> show(int codigo_agregar_libro);



    /**
     * Elimina un agrega_libro_transaccion de la base de datos por su serial_alt.
     * Si la conexion falla o si no encuentra el serial_alt lanzará excepción.
     *
     * @param serial_alt identificador del agrega_libro_transaccion que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el serial_alt.
     */
    public void delete(int codigo_agregar_libro);

}
