package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Categoria;
import java.util.List;

public interface Categoriarepository {
    /**
     * Inserta un categoria en la tabla Categoria.
     * Al ser el todos sus atributos obligatorios (excepto codigo_categoria), si son nulos o vacíos se lanzará
     * una excepción o si la conexion falla .
     *
     * @param categoria objeto de la clase Categoria que tiene los atributos correspondientes a insertar como Categoria.
     * @return retorna un Categoria que contiene la categoria creado o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */
    public Categoria crear(Categoria categoria);

    /**
     * Inserta datos en una categoria en la tabla Categoria.
     * Al ser el todos sus atributos obligatorios (excepto codigo_categoria), si son nulos o vacíos se lanzará
     * una excepción, si la conexion falla o si no encuentra el codigo_categoria.
     *
     * @param categoria objeto de la clase Categoria que tiene los atributos correspondientes a insertar en una categoria.
     * @param codigo_categoria int correspondiente al codigo_categoria de la categoria a la cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo_categoria.
     */
    public String update(Categoria categoria, int codigo_categoria);


    /**
     * Lista todos los categorias de la base de datos ascendente por nombre.
     * Si la conexion falla lanzará excepción.
     *
     * @return retorna una lista de Categoria que contiene las categorias o null si se lanza excepcion.
     * @throws Exception Si la conexion falla.
     */
    public List<Categoria> getAll();


    /**
     * Lista un Categoria con un codigo_categoria especifico de la base de datos.
     * Si la conexion falla o si no encuentra el codigo_categoria lanzará excepción.
     *
     * @param codigo_categoria codigo de la categoria que se desea mostrar.
     * @return retorna una lista de Categoria que contiene la categoria con el codigo_categoria solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_categoria.
     */
    public List<Categoria> show(int codigo_categoria);



    /**
     * Elimina un Categoria de la base de datos por su codigo_categoria.
     * Si la conexion falla o si no encuentra el codigo_categoria lanzará excepción.
     *
     * @param codigo_categoria identificador de la categoria que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_categoria.
     */
    public void delete(int codigo_categoria);

}

