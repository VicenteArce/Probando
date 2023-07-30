package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class Librorepositoryimp implements Librorepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Libro crear(Libro libro) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO libro(id_libro, nombre_libro, precio, stock, ubicacion_geografica, restriccion_de_edad, url, codigo_permiso)" +
                    "VALUES (:id_libro, :nombre_libro, :precio, :stock, :ubicacion_geografica, :restriccion_de_edad, :url, :codigo_permiso)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro", libro.getId_libro())
                    .addParameter("nombre_libro", libro.getNombre_libro())
                    .addParameter("precio", libro.getPrecio())
                    .addParameter("stock", libro.getStock())
                    .addParameter("ubicacion_geografica", libro.getUbicacion_geografica())
                    .addParameter("restriccion_de_edad", libro.getRestriccion_de_edad())
                    .addParameter("codigo_permiso", libro.getCodigo_permiso())
                    .addParameter("url", libro.getUrl())
                    .executeUpdate();
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Libro libro, int Id_libro) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update libro set nombre_libro=:nombre_libro, precio=:precio,stock=:stock, ubicacion_geografica=:ubicacion_geografica,restriccion_de_edad=:restriccion_de_edad,codigo_permiso=:codigo_permiso,url=:url WHERE id_libro=:id_libro";
            conn.createQuery(updateSql)
                    .addParameter("id_libro",Id_libro)
                    .addParameter("nombre_libro", libro.getNombre_libro())
                    .addParameter("precio", libro.getPrecio())
                    .addParameter("stock", libro.getStock())
                    .addParameter("ubicacion_geografica", libro.getUbicacion_geografica())
                    .addParameter("restriccion_de_edad", libro.getRestriccion_de_edad())
                    .addParameter("url", libro.getUrl())
                    .addParameter("codigo_permiso", libro.getCodigo_permiso())
                    .executeUpdate();
            return "Se actualizó el libro";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar libro";
        }
    }
    @Override
    public List<Libro> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro order by nombre_libro ASC")
                    .executeAndFetch(Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro> show(int id_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro where id_libro =:id_libro ")
                    .addParameter("id_libro", id_libro)
                    .executeAndFetch(Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro> showLessThan(int precio) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro where precio< :precio ::int")
                    .addParameter("precio", precio)
                    .executeAndFetch(Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_libro) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from libro where id_libro =:id_libro")
                    .addParameter("id_libro",id_libro)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}


