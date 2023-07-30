package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Lista_favoritos;
import java.util.List;

public interface Lista_favoritosrepository {

        /**
         *
         * Inserta un nuevo lista_favoritos en la tabla lista_favoritos.
         * Dado que todos sus atributos son obligatorios (excepto código_listafavoritos), si son nulos o están vacíos o si falla la conexión se producirá excepción.
         *
         * @param lista_favoritos objeto de la clase Lista_favoritos que tiene los atributos correspondientes para insertar como lista_favoritos.
         * @return devuelve un Lista_favoritos que contiene el lista_favoritos creado o null si se lanza una excepción.
         */


        public Lista_favoritos crear(Lista_favoritos lista_favoritos);

        /**
         * modifica los datos de un lista_favoritos en la tabla lista_favoritos.
         * Dado que todos sus atributos son obligatorios (excepto código_listafavoritos), si son nulos o vacíos , o si la conexion falla o si no encuentra el codigo.
         * se lanzará una excepción
         *
         * @param codigo_lista_favoritos int correspondiente al codigo del lista_favoritos cuyos datos se desea modificar.
         * @return devuelve una string que indica el éxito de la actualización de datos.
         * @throws Exception una excepción si uno de los atributos es null o está vacío, o si no se encuentra el código_listafavoritos.
         */

        String update(Lista_favoritos lista_favoritos, int codigo_lista_favoritos);

        /** Lista todos los lista_favoritos en la base de datos en orden ascendente por codigo_usuario.
         * * Si falla la conexión o si no se encuentra el código_listafavoritos, se generará una excepción.
         *
         * @return devuelve una lista de Lista_favoritos que contiene los lista_favoritos o null si se lanza una excepción.
         * @throws Exception Si la conexion falla.
         *
         */

        public List<Lista_favoritos> getAll();

        /**
         * Lista un lista_favoritos con un codigo_lista_favoritos de la base de datos.
         * Si la conexion falla o si no encuentra el codigo_lista_favoritos se generara una excepción.
         *
         * @param codigo_lista_favoritos identificador de lista_favoritos a mostrar.
         * @return retorna una lista de Lista_favoritos que contiene los lista_favoritos con el codigo_listafavoritos solicitado o null si se lanza excepcion.
         * @throws Exception Si la conexion falla o si no encuentra el codigo_listafavoritos.
         */

        public List<Lista_favoritos> show(int codigo_lista_favoritos);

        /**
         * Busca un lista_favoritos de la base de datos segun su codigo_listafavoritos y lo elimina.
         * Si la conexion falla o si no encuentra el codigo_listafavoritos se producirá excepción.
         *
         * @param codigo_lista_favoritos identificador del lista_favoritos que se desea eliminar.
         * @throws Exception Si la conexion falla o si no encuentra el codigo_listafavoritos.
         */

        public void delete(int codigo_lista_favoritos);

}
