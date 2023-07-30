package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Historialrepositoryimp implements Historialrepository{
    @Autowired
    private Sql2o sql2o;

    //C
    @Override
    public Historial crear(Historial historial) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO historial(codigo_historial,codigo_usuario)" +
                    "VALUES (:codigo_historial,:codigo_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_historial",historial.getCodigo_historial())
                    .addParameter("codigo_usuario",historial.getCodigo_usuario())
                    .executeUpdate();
            return historial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //U
    @Override
    public String update(Historial historial, int codigo_historial) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update historial set codigo_usuario=:codigo_usuario WHERE codigo_historial=:codigo_historial";
            conn.createQuery(updateSql)
                    .addParameter("codigo_historial", codigo_historial)
                    .addParameter("codigo_usuario", historial.getCodigo_usuario())
                    .executeUpdate();
            return "Se actualizó el historial";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar el historial";
        }
    }

    //R
    @Override
    public List<Historial> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from historial order by codigo_historial ASC")
                    .executeAndFetch(Historial.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Historial> show(int codigo_historial){
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from historial where codigo_historial=:codigo_historial ")
                    .addParameter("codigo_historial", codigo_historial)
                    .executeAndFetch(Historial.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //D

    public void delete(int codigo_historial) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from historial where codigo_historial =:codigo_historial")
                    .addParameter("codigo_historial",codigo_historial)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





}
