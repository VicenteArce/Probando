package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Historial_libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Historial_librorepositoryimp implements  Historial_librorepository {

    @Autowired
    private Sql2o sql2o;

    //C
    @Override
    public Historial_libro crear(Historial_libro historial_Libro) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO historial_libro(codigo_historial_libro,id_libro,codigo_historial )" +
                    "VALUES (:codigo_historial_libro, :id_libro,:codigo_historial)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_historial_libro", historial_Libro.getCodigo_historial_libro())
                    .addParameter("id_libro", historial_Libro.getId_libro())
                    .addParameter("codigo_historial", historial_Libro.getCodigo_historial())
                    .executeUpdate();
            return historial_Libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    //U
    @Override
    public String update(Historial_libro historial_libro, int codigo_historial_libro) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update historial_libro set id_libro=:id_libro, codigo_historial =:codigo_historial  WHERE codigo_historial_libro =:codigo_historial_libro";
            conn.createQuery(updateSql)
                    .addParameter("codigo_historial_libro", codigo_historial_libro)
                    .addParameter("id_libro", historial_libro.getId_libro())
                    .addParameter("codigo_historial", historial_libro.getCodigo_historial())
                    .executeUpdate();
            return "Se actualizó Historial libro";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Historial libro";
        }
    }

    //R
    @Override
    public List<Historial_libro> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from historial_libro order by codigo_historial_libro ASC")
                    .executeAndFetch(Historial_libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Historial_libro> show(int codigo_historial_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from historial_libro where codigo_historial_libro=:codigo_historial_libro ")
                    .addParameter("codigo_historial_libro", codigo_historial_libro)
                    .executeAndFetch(Historial_libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    //D
    public void delete(int codigo_historial_libro) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from historial_libro where codigo_historial_libro=:codigo_historial_libro ")
                    .addParameter("codigo_historial_libro", codigo_historial_libro)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
