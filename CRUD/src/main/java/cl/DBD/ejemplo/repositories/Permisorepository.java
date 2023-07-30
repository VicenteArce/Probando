package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Permiso;

import java.util.List;


public interface Permisorepository {
    /**
     * @param permiso objeto de la clase Permiso que tiene los atributos correspondientes a insertar.
     * @return retorna un Permiso que contiene los permisos o null si se lanza excepcion.
     * @throws Exception Si uno de los atributos es null o vacio.
     */
    public Permiso crear(Permiso permiso);


    /**
     * @param permiso objeto de la clase Permiso que tiene los atributos correspondientes a insertar.
     * @param codigo_permiso int correspondiente al permiso al cual se desea insertar datos.
     * @return retorna un string que indica el exito de la actualización de los datos.
     * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el codigo.
     */
    public String update(Permiso permiso, int codigo_permiso );


    /** Lista todos los Permisos de la base de datos de manera ascendente por codigo_permiso.
     *
     * @return retorna una lista de historiales.
     * @throws Exception Si la conexion falla.
     */
    public List<Permiso> getAll();


    /**
     * @param codigo_permiso identificador del permiso que se desea mostrar.
     * @return retorna una lista de permisos que contiene el codigo_permiso solicitado o null si se lanza excepcion.
     * @throws Exception Si la conexion falla o si no encuentra el codigo_permiso.
     */
    public List<Permiso> show(int codigo_permiso);


    /**
     * Elimina un Permiso de la base de datos por su codigo_permiso.
     * Si la conexion falla o si no encuentra el codigo_permiso lanzará excepción.
     *
     * @param codigo_permiso identificador del Permiso que se desea eliminar.
     * @throws Exception Si la conexion falla o si no encuentra el codigo.
     */
    public void delete(int codigo_permiso);
}
