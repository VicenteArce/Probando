package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.Models.Libro_categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Libro_categoriarepositoryimp implements Libro_categoriarepository{


    @Autowired
    private Sql2o sql2o;

    @Override
    public Libro_categoria crear(Libro_categoria libro_categoria) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO libro_categoria(codigo_libro_categoria, codigo_categoria, id_libro)" +
                    "VALUES (:codigo_libro_categoria, :codigo_categoria, :id_libro)";
            conn.createQuery(sql, true)
                    .addParameter("codigo_libro_categoria", libro_categoria.getCodigo_libro_categoria())
                    .addParameter("codigo_categoria", libro_categoria.getCodigo_categoria())
                    .addParameter("id_libro", libro_categoria.getId_libro())
                    .executeUpdate();
            return libro_categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    @Override
    public String update(Libro_categoria libro_categoria, int codigo_libro_categoria) {
        try (Connection conn = sql2o.open()){
            String updateSql = "update libro_categoria set codigo_categoria =: codigo_categoria, id_libro =: id_libro WHERE codigo_libro_categoria=:codigo_libro_categoria";
            conn.createQuery(updateSql)
                    .addParameter("codigo_libro_categoria", codigo_libro_categoria)
                    .addParameter("codigo_categoria", libro_categoria.getCodigo_libro_categoria())
                    .addParameter("id_libro", libro_categoria.getId_libro())
                    .executeUpdate();
            return "Se actualizó el libro_categoria";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar el libro_categoria";
        }
    }

    @Override
    public List<Libro_categoria> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro_categoria order by codigo_libro_categoria ASC")
                    .executeAndFetch(Libro_categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro_categoria> show(int codigo_libro_categoria) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from libro_categoria where codigo_libro_categoria =: codigo_libro_categoria ")
                    .addParameter("codigo_libro_categoria", codigo_libro_categoria)
                    .executeAndFetch(Libro_categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public void delete(int codigo_libro_categoria) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from libro_categoria where codigo_libro_categoria =:codigo_libro_categoria")
                    .addParameter("codigo_libro_categoria",codigo_libro_categoria)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
