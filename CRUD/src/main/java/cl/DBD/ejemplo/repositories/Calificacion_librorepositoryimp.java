package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Calificacion_libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Calificacion_librorepositoryimp implements Calificacion_librorepository{
    @Autowired
    private Sql2o sql2o;
    @Override
        public Calificacion_libro crear(Calificacion_libro calificacion_libro) {
            try (Connection conn = sql2o.open()) {
                String sql = "INSERT INTO calificacion_libro(codigo_calificacion_libro,codigo_usuario,id_libro,valoracion)" +
                        "VALUES (:codigo_calificacion_libro,:codigo_usuario,:id_libro,:valoracion)";
                conn.createQuery(sql, true)
                        .addParameter("codigo_calificacion_libro", calificacion_libro.getCodigo_calificacion())
                        .addParameter("valoracion",calificacion_libro.getValoracion())
                        .addParameter("codigo_usuario", calificacion_libro.getCodigo_usuario())
                        .addParameter("id_libro",calificacion_libro.getId_libro())
                        .executeUpdate();
                return calificacion_libro;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }


    @Override
    public String update(Calificacion_libro calificacion_libro, int codigo_calificacion_libro) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update calificacion_libro set codigo_usuario=:codigo_usuario, id_libro=:id_libro, valoracion=:valoracion WHERE codigo_calificacion_libro=:codigo_calificacion_libro";
            conn.createQuery(updateSql)
                    .addParameter("codigo_calificacion_libro", codigo_calificacion_libro)
                    .addParameter("valoracion",calificacion_libro.getValoracion())
                    .addParameter("codigo_usuario", calificacion_libro.getCodigo_usuario())
                    .addParameter("id_libro",calificacion_libro.getId_libro())
                    .executeUpdate();
            return "Se actualizó la calificacion";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar la calificacion";
        }
    }

    @Override
    public List<Calificacion_libro> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from calificacion_libro order by valoracion ASC")
                    .executeAndFetch(Calificacion_libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Calificacion_libro> show(int codigo_calificacion) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from calificacion_libro where codigo_calificacion=:codigo_calificacion ")
                    .addParameter("codigo_calificacion", codigo_calificacion)
                    .executeAndFetch(Calificacion_libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Calificacion_libro> showLessThan(int valoracion) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from calificacion_libro where valoracion<:valoracion ::int")
                    .addParameter("valoracion", valoracion)
                    .executeAndFetch(Calificacion_libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Calificacion_libro> showMoreThan(int valoracion) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from calificacion_libro where valoracion> :valoracion ::int")
                    .addParameter("valoracion", valoracion)
                    .executeAndFetch(Calificacion_libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public void delete(int codigo_calificacion_libro) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from calificacion_libro where codigo_calificacion_libro =:codigo_calificacion_libro")
                    .addParameter("codigo_calificacion_libro",codigo_calificacion_libro)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

