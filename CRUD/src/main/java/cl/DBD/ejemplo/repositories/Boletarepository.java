package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Boleta;

import java.util.List;

public interface Boletarepository {

    /**
     * Inserta un nuevo boleta en la tabla boleta.
     * Dado que todos sus atributos son obligatorios (excepto codigo_boleta), si son nulos o están vacíos o si falla la conexion se producirá excepción.
     *
     * @param boleta objeto de la clase boleta que tiene los atributos correspondientes a insertar como boleta.
     * @return retorna un boleta que contiene el boleta creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */

    public Boleta crear(Boleta boleta);

    /**
     * Inserta datos en un boleta en la tabla boleta.
     * Al ser el todos sus atributos obligatorios (excepto codigo_boleta), si son nulos o vacíos se lanzará
     * una excepción, si la conexion falla o si no encuentra el codigo.
     *
     * @param boleta objeto de la clase boleta que tiene los atributos correspondientes a insertar en un boleta.
     * @param codigo_boleta int correspondiente al codigo de boleta al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */

    String update(Boleta boleta, int codigo_boleta);

    /** Lista todos los boletas de la base de datos de manera ascendente por codigo_boleta.
     * * Si la conexion falla o si no encuentra el codigo_boleta se lanzará excepción.
     *
     * @return retorna una lista de boleta que contiene los boletas o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     *
     */

    public List<Boleta> getAll();

    /**
     * Lista un boleta con un codigo_boleta especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_boleta lanzará excepción.
     *
     * @param codigo_boleta identificador del boleta que se desea mostrar.
     * @return retorna una lista de Boleta que contiene el boleta con el codigo_boleta solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_boleta.
     */

    public List<Boleta> show(int codigo_boleta);



    /**
     * Elimina un boleta de la base de datos por su codigo_boleta.
     * Si la conexion falla o si no encuentra el codigo_boleta lanzará excepción.
     *
     * @param codigo_boleta identificador del boleta que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */
    public void delete(int codigo_boleta);

}
