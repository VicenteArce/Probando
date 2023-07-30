package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Permiso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Permisorepositoryimp implements Permisorepository{
    @Autowired
    private Sql2o sql2o;

    //C
    @Override
    public Permiso crear(Permiso permiso) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO permiso(codigo_permiso,codigo_tipo_usuario)" +
                    "VALUES (:codigo_permiso,:codigo_tipo_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_permiso", permiso.getCodigo_permiso())
                    .addParameter("codigo_tipo_usuario", permiso.getCodigo_tipo_usuario())
                    .executeUpdate();
            return permiso;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //U
    @Override
    public String update(Permiso permiso, int codigo_permiso) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update permiso set codigo_tipo_usuario=:codigo_tipo_usuario WHERE codigo_permiso=:codigo_permiso";
            conn.createQuery(updateSql)
                    .addParameter("codigo_permiso", codigo_permiso)
                    .addParameter("codigo_tipo_usuario",permiso.getCodigo_tipo_usuario())
                    .executeUpdate();
            return "Se actualizaron los permisos";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar los permisos";
        }
    }

    //R
    @Override
    public List<Permiso> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from permiso order by codigo_permiso ASC")
                    .executeAndFetch(Permiso.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Permiso> show(int codigo_permiso){
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from permiso where codigo_permiso=:codigo_permiso ")
                    .addParameter("codigo_permiso", codigo_permiso)
                    .executeAndFetch(Permiso.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //D
    @Override
    public void delete(int codigo_permiso) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from permiso where codigo_permiso =: codigo_permiso")
                    .addParameter("codigo_permiso",codigo_permiso)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }






}
