package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Carrito_de_compras;
import java.util.List;

public interface Carrito_de_comprasrepository {

    /**
     * Inserta un nuevo carrito de compras en la tabla carrito de compras.
     *
     * @param carrito_de_compras objeto de la clase carrito de compras que tiene los atributos correspondientes a insertar como carrito de compras.
     * @return retorna un carrito de compras que contiene el carrito de compras o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */
    public Carrito_de_compras crear(Carrito_de_compras carrito_de_compras);


    /**
     * Inserta datos en un carrito de compras.
     * Se lanza una excepción, si la conexion falla o si no encuentra el codigo.
     *
     * @param carrito_de_compras objeto de la clase boleta que tiene los atributos correspondientes a insertar en un carrito de compras.
     * @param codigo_carrito int correspondiente al codigo carrito al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */
    public String update(Carrito_de_compras carrito_de_compras, int codigo_carrito);


    /** Lista todos los carritos de compra de la base de datos de manera ascendente por codigo_carrito.
     *
     * @return retorna una lista de carritos de compra.
     * @throws Exception Si la conexion falla.
     */
    public List<Carrito_de_compras> getAll();


    /**
     * Lista un carrito dde compra con un codigo_carrito especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_carrito lanzará excepción.
     *
     * @param codigo_carrito identificador del carrito que se desea mostrar.
     * @return retorna una lista de carrito que contiene el codigo_boleta solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_carrito.
     */
    public List<Carrito_de_compras> show(int codigo_carrito);

    /**
     * Elimina un carrito de la base de datos por su codigo_carrito.
     * Si la conexion falla o si no encuentra el codigo_carrito lanzará excepción.
     *
     * @param codigo_carrito identificador del carrito que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */
    public void delete(int codigo_carrito);
}
