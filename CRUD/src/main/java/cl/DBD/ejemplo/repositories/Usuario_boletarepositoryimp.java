package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.Models.Usuario_boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository

public class Usuario_boletarepositoryimp implements Usuario_boletarepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Usuario_boleta crear(Usuario_boleta usuario_boleta) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO usuario_boleta(codigo_usuario_boleta,codigo_boleta,codigo_usuario)" +
                    "VALUES (:codigo_usuario_boleta,:codigo_boleta,:codigo_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_usuario_boleta", usuario_boleta.getCodigo_usuario_boleta())
                    .addParameter("codigo_boleta", usuario_boleta.getCodigo_boleta())
                    .addParameter("codigo_usuario",usuario_boleta.getCodigo_usuario())
                    .executeUpdate();
            return usuario_boleta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Usuario_boleta usuario_boleta, int codigo_usuario_boleta) {
        try (Connection conn = sql2o.open()){
            String updateSql = "update usuario_boleta set codigo_boleta=:codigo_boleta, codigo_usuario=:codigo_usuario WHERE codigo_usuario_boleta=:codigo_usuario_boleta";
            conn.createQuery(updateSql)
                    .addParameter("codigo_usuario_boleta", codigo_usuario_boleta)
                    .addParameter("codigo_boleta", usuario_boleta.getCodigo_boleta())
                    .addParameter("codigo_usuario", usuario_boleta.getCodigo_usuario())
                    .executeUpdate();
            return "Se actualizó el usuario_boleta";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar el usuario_boleta";
        }
    }

    @Override
    public List<Usuario_boleta> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from usuario_boleta order by codigo_usuario ASC")
                    .executeAndFetch(Usuario_boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario_boleta> show(int codigo_usuario_boleta) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from usuario_boleta where codigo_usuario_boleta=:codigo_usuario_boleta ")
                    .addParameter("codigo_usuario_boleta", codigo_usuario_boleta)
                    .executeAndFetch(Usuario_boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public void delete(int codigo_usuario_boleta) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from usuario_boleta where codigo_usuario_boleta=:codigo_usuario_boleta")
                    .addParameter("codigo_usuario_boleta",codigo_usuario_boleta)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

