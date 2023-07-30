package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository public class Categoriarepositoryimp implements Categoriarepository{


    @Autowired
    private Sql2o sql2o;

    @Override
    public Categoria crear(Categoria categoria) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO categoria(codigo_categoria,nombre_categoria)" +
                    "VALUES (:codigo_categoria, :nombre_categoria)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_categoria", categoria.getCodigo_categoria())
                    .addParameter("nombre_categoria", categoria.getNombre_categoria())
                    .executeUpdate();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public String update(Categoria categoria, int codigo_categoria) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update categoria set nombre_categoria=:nombre_categoria WHERE codigo_categoria=:codigo_categoria";
            conn.createQuery(updateSql)
                    .addParameter("codigo_categoria", codigo_categoria)
                    .addParameter("nombre_categoria", categoria.getNombre_categoria())
                    .executeUpdate();
            return "Se actualizó categoria";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar categoria";
        }
    }
    @Override
    public List<Categoria> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from categoria order by nombre_categoria ASC")
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> show(int codigo_categoria) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from categoria where codigo_categoria =:codigo_categoria ")
                    .addParameter("codigo_categoria", codigo_categoria)
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int codigo_categoria) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from categoria where codigo_categoria =:codigo_categoria ")
                    .addParameter("codigo_categoria", codigo_categoria)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

