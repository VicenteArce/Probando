package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Carrito_de_compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Carrito_de_comprasimp implements Carrito_de_comprasrepository{
    @Autowired
    private Sql2o sql2o;
    //C
    @Override
    public Carrito_de_compras crear(Carrito_de_compras carrito_de_compras) {
            try (Connection conn = sql2o.open()) {
                String sql = "INSERT INTO carrito_de_compras(codigo_carrito,codigo_usuario)" +
                        "VALUES (:codigo_carrito,:codigo_usuario)";
                conn.createQuery(sql, true)
                        .addParameter("codigo_carrito", carrito_de_compras.getCodigo_carrito())
                        .addParameter("codigo_usuario",carrito_de_compras.getCodigo_usuario())
                        .executeUpdate();
                return carrito_de_compras;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

    //U
    @Override
    public String update(Carrito_de_compras carrito_de_compras, int codigo_carrito) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update carrito_de_compras set codigo_usuario=:codigo_usuario WHERE codigo_carrito=:codigo_carrito";
            conn.createQuery(updateSql)
                    .addParameter("codigo_carrito", codigo_carrito)
                    .addParameter("codigo_usuario", carrito_de_compras.getCodigo_usuario())
                    .executeUpdate();
            return "Se actualizó carrito de compras";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar carrito de compras";
        }
    }

    //R
    @Override
    public List<Carrito_de_compras> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carrito_de_compras order by codigo_carrito ASC")
                    .executeAndFetch(Carrito_de_compras.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Carrito_de_compras> show(int codigo_carrito) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from carrito_de_compras where codigo_carrito =:codigo_carrito ")
                    .addParameter("codigo_carrito", codigo_carrito)
                    .executeAndFetch(Carrito_de_compras.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //D
    @Override
    public void delete(int codigo_carrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from carrito_de_compras where codigo_carrito =:codigo_carrito")
                    .addParameter("codigo_carrito",codigo_carrito)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

