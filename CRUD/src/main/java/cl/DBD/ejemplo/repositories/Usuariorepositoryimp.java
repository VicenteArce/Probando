package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class Usuariorepositoryimp implements Usuariorepository{

    @Autowired
    private Sql2o sql2o;

    public Usuario crear(Usuario usuario) {
        try (Connection conn = sql2o.open()) {

            String sql = "INSERT INTO usuario(codigo_usuario, nombre_usuarios, fecha_nacimiento, email_usuario, contrasena, ubicacion_geografica)" +
                    "VALUES (:codigo_usuario, :nombre_usuarios, :fecha_nacimiento, :email_usuario, :contrasena, :ubicacion_geografica)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_usuario", usuario.getCodigo_usuario())
                    .addParameter("nombre_usuarios", usuario.getNombre_usuario())
                    .addParameter("fecha_nacimiento", usuario.getFecha_nacimiento())
                    .addParameter("email_usuario", usuario.getEmail_usuario())
                    .addParameter("contrasena", usuario.getContrasena())
                    .addParameter("ubicacion_geografica", usuario.getUbicacion_geografica())
                    .executeUpdate();
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }
    }
    @Override
    public String update(Usuario usuario, int codigo_usuario) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update usuario set nombre_usuarios=:nombre_usuarios, fecha_nacimiento=:fecha_nacimiento, email_usuario=:email_usuario,  contrasena=:contrasena, ubicacion_geografica=:ubicacion_geografica WHERE codigo_usuario=:codigo_usuario";
            conn.createQuery(updateSql)
                    .addParameter("codigo_usuario", codigo_usuario)
                    .addParameter("nombre_usuarios",usuario.getNombre_usuario())
                    .addParameter("fecha_nacimiento", usuario.getFecha_nacimiento())
                    .addParameter("email_usuario",usuario.getEmail_usuario())
                    .addParameter("contrasena",usuario.getContrasena())
                    .addParameter("ubicacion_geografica",usuario.getUbicacion_geografica())
                    .executeUpdate();
            return "Se actualizó el usuario";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar usuario";
        }
    }

    @Override
    public List<Usuario> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from usuario order by nombre_usuarios ASC")
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> show(int codigo_usuario) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from usuario where codigo_usuario =:codigo_usuario ")
                    .addParameter("codigo_usuario", codigo_usuario)
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int codigo_usuario) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from usuario where codigo_usuario =:codigo_usuario")
                    .addParameter("codigo_usuario",codigo_usuario)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
