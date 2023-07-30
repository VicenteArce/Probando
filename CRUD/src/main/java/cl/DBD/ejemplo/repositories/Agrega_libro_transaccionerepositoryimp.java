package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Agrega_libro_transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Agrega_libro_transaccionerepositoryimp implements Agrega_libro_transaccionrepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Agrega_libro_transaccion crear(Agrega_libro_transaccion agrega_libro_transaccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO agregar_libro_transaccion(codigo_agregar_libro, codigo_carrito, id_libro)" +
                    "VALUES (:codigo_agregar_libro, :codigo_carrito, :id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_agregar_libro",agrega_libro_transaccion.getSerial_alt())
                    .addParameter("codigo_carrito", agrega_libro_transaccion.getCodigo_carrito())
                    .addParameter("id_libro", agrega_libro_transaccion.getId_libro())
                    .executeUpdate();
            return agrega_libro_transaccion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Agrega_libro_transaccion agrega_libro_transaccion, int codigo_agregar_libro) {
        try (Connection conn = sql2o.open()){
            String updateSql = "update agregar_libro_transaccion set codigo_carrito =:codigo_carrito, id_libro =:id_libro WHERE codigo_agregar_libro =:codigo_agregar_libro";
            conn.createQuery(updateSql)
                    .addParameter("serial_alt",codigo_agregar_libro)
                    .addParameter("codigo_carrito", agrega_libro_transaccion.getCodigo_carrito())
                    .addParameter("id_libro", agrega_libro_transaccion.getId_libro())
                    .executeUpdate();
            return "Se actualizó el agrega_libro_transaccion";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar el agrega_libro_transaccion";
        }
    }

    @Override
    public List<Agrega_libro_transaccion> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from agregar_libro_transaccion order by codigo_agregar_libro ASC")
                    .executeAndFetch(Agrega_libro_transaccion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Agrega_libro_transaccion> show(int codigo_agregar_libro) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from agregar_libro_transaccion where codigo_agregar_libro =:codigo_agregar_libro ")
                    .addParameter("codigo_agregar_libro", codigo_agregar_libro)
                    .executeAndFetch(Agrega_libro_transaccion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public void delete(int codigo_agregar_libro) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from agregar_libro_transaccion where codigo_agregar_libro =:codigo_agregar_libro")
                    .addParameter("codigo_agregar_libro",codigo_agregar_libro)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
