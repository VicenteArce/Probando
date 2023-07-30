package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Lista_favoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Lista_favoritosrepositoryimp implements Lista_favoritosrepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Lista_favoritos crear(Lista_favoritos lista_favoritos) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO lista_favoritos(codigo_lista_favoritos, codigo_usuario)" +
                    "VALUES (:codigo_lista_favoritos, :codigo_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_lista_favoritos", lista_favoritos.getCodigo_listafavoritos())
                    .addParameter("codigo_usuario", lista_favoritos.getCodigo_usuario())
                    .executeUpdate();
            return lista_favoritos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Lista_favoritos lista_favoritos, int codigo_lista_favoritos) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update lista_favoritos set codigo_usuario=:codigo_usuario WHERE codigo_lista_favoritos=:codigo_lista_favoritos";
            conn.createQuery(updateSql)
                    .addParameter("codigo_lista_favoritos",codigo_lista_favoritos)
                    .addParameter("codigo_usuario", lista_favoritos.getCodigo_usuario())
                    .executeUpdate();
            return "Se actualizó el lista_favoritos";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar lista_favoritos";
        }
    }
    @Override
    public List<Lista_favoritos> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from lista_favoritos order by codigo_usuario ASC")
                    .executeAndFetch(Lista_favoritos.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lista_favoritos> show(int codigo_lista_favoritos) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from lista_favoritos where codigo_lista_favoritos=:codigo_lista_favoritos")
                    .addParameter("codigo_lista_favoritos", codigo_lista_favoritos)
                    .executeAndFetch(Lista_favoritos.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public void delete(int codigo_lista_favoritos) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from lista_favoritos where codigo_lista_favoritos=:codigo_lista_favoritos")
                    .addParameter("codigo_lista_favoritos",codigo_lista_favoritos)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
