package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class Boletarepositoryimp implements Boletarepository{


    @Autowired
    private Sql2o sql2o;

    @Override
    public Boleta crear(Boleta boleta) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO boleta(codigo_boleta, tipo_de_pago, codigo_carrito)" +
                    "VALUES (:codigo_boleta, :tipo_de_pago, :codigo_carrito)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_boleta", boleta.getCodigo_boleta())
                    .addParameter("tipo_de_pago",boleta.getTipo_de_pago())
                    .addParameter("codigo_carrito",boleta.getCodigo_carrito())
                    .executeUpdate();
            return boleta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Boleta boleta, int codigo_boleta) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update boleta set medio_de_pago =:medio_de_pago, codigo_carrito =:codigo_carrito WHERE codigo_boleta =:codigo_boleta";
            conn.createQuery(updateSql)
                    .addParameter("codigo_boleta", codigo_boleta)
                    .addParameter("tipo_de_pago",boleta.getTipo_de_pago())
                    .addParameter("codigo_carrito",boleta.getCodigo_carrito())
                    .executeUpdate();
            return "Se actualizó la boleta";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar boleta";
        }
    }

    @Override
    public List<Boleta> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from boleta order by codigo_boleta ASC")
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Boleta> show(int codigo_boleta) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from boleta where codigo_boleta =:codigo_boleta ")
                    .addParameter("codigo_boleta", codigo_boleta)
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int codigo_boleta) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from boleta where codigo_boleta =:codigo_boleta")
                    .addParameter("codigo_boleta", codigo_boleta)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
