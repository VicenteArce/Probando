package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Libro_lista_favoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Libro_lista_favoritosrepositoryimp implements Libro_lista_favoritosrepository{


    @Autowired
    private Sql2o sql2o;

    @Override
    public Libro_lista_favoritos crear(Libro_lista_favoritos libro_lista_favoritos) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO libro_lista_favoritos(codigo_lista_libro_favoritos, codigo_lista_favoritos, id_libro)" +
                    "VALUES (:codigo_lista_libro_favoritos, :codigo_listafavoritos, :id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_lista_libro_favoritos",libro_lista_favoritos.getCodigo_lista_libro_favoritos())
                    .addParameter("codigo_listafavoritos",libro_lista_favoritos.getCodigo_listafavoritos())
                    .addParameter("id_libro",libro_lista_favoritos.getId_libro())
                    .executeUpdate();
            return libro_lista_favoritos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Libro_lista_favoritos libro_lista_favoritos, int codigo_lista_libro_favoritos) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update libro_lista_favoritos set codigo_lista_favoritos=:codigo_listafavoritos, id_libro=:id_libro WHERE codigo_lista_libro_favoritos=:codigo_lista_libro_favoritos";
            conn.createQuery(updateSql)
                    .addParameter("codigo_lista_libro_favoritos",codigo_lista_libro_favoritos)
                    .addParameter("codigo_listafavoritos",libro_lista_favoritos.getCodigo_listafavoritos())
                    .addParameter("id_libro",libro_lista_favoritos.getId_libro())
                    .executeUpdate();
            return "Se actualizó el libro_lista_favoritos";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar libro_lista_favoritos";
        }
    }

    @Override
    public List<Libro_lista_favoritos> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro_lista_favoritos order by codigo_lista_libro_favoritos ASC")
                    .executeAndFetch(Libro_lista_favoritos.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro_lista_favoritos> show(int codigo_lista_libro_favoritos) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro_lista_favoritos where codigo_lista_libro_favoritos=:codigo_lista_libro_favoritos ")
                    .addParameter("codigo_lista_libro_favoritos", codigo_lista_libro_favoritos)
                    .executeAndFetch(Libro_lista_favoritos.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override

    public void delete(int codigo_lista_libro_favoritos) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from libro_lista_favoritos where codigo_lista_libro_favoritos =:codigo_lista_libro_favoritos")
                    .addParameter("codigo_lista_libro_favoritos",codigo_lista_libro_favoritos)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
