package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Tipo_usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Tipo_usuarioimplementacion implements Tipo_usuariorepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public Tipo_usuario crear(Tipo_usuario tipo_usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO tipo_usuario(codigo_tipo_usuario,nombre_tipo_usuario,codigo_usuario)" +
                    "VALUES (:codigo_tipo_usuario,:nombre_tipo_usuario,:codigo_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_tipo_usuario", tipo_usuario.getCodigo_tipo_usuario())
                    .addParameter("nombre_tipo_usuario", tipo_usuario.getNombre_tipo_usuario())
                    .addParameter("codigo_usuario", tipo_usuario.getCodigo_usuario())
                    .executeUpdate();
            return tipo_usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Tipo_usuario tipo_usuario, int codigo_tipo_usuario) {
        try (Connection conn = sql2o.open()) {
            String updateSql= "update tipo_usuario set nombre_tipo_usuario=:nombre_tipo_usuario, codigo_usuario=:codigo_usuario where codigo_tipo_usuario=:codigo_tipo_usuario";
            conn.createQuery(updateSql)
                    .addParameter("codigo_tipo_usuario", codigo_tipo_usuario)
                    .addParameter("nombre_tipo_usuario", tipo_usuario.getNombre_tipo_usuario())
                    .addParameter("codigo_usuario", tipo_usuario.getCodigo_usuario())
                    .executeUpdate();
            return "Se actualizó el tipo_usuario";
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return "Fallo al actualizar tipo_usuario";
    }
    }

    @Override
    public List<Tipo_usuario> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from tipo_usuario order by nombre_tipo_usuario ASC")
                    .executeAndFetch(Tipo_usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tipo_usuario> show(int codigo_tipo_usuario) {
            try (Connection conn = sql2o.open()) {
                return conn.createQuery("select * from tipo_usuario where  codigo_tipo_usuario=:codigo_tipo_usuario ")
                        .addParameter("codigo_tipo_usuario", codigo_tipo_usuario)
                        .executeAndFetch(Tipo_usuario.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

    @Override
    public void delete(int codigo_tipo_usuario) {
            try(Connection conn = sql2o.open()){
                conn.createQuery("DELETE from tipo_usuario where codigo_tipo_usuario =:codigo_tipo_usuario")
                        .addParameter("codigo_tipo_usuario",codigo_tipo_usuario)
                        .executeUpdate();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

}


