package cl.DBD.ejemplo.Models;

public class Libro_categoria {
    private int codigo_libro_categoria;
    private int id_libro;
    private int codigo_categoria;

    public Libro_categoria(int codigo_libro_categoria, int id_libro, int codigo_categoria) {
        this.codigo_libro_categoria = codigo_libro_categoria;
        this.id_libro = id_libro;
        this.codigo_categoria = codigo_categoria;
    }

    public int getCodigo_libro_categoria() {
        return codigo_libro_categoria;
    }

    public void setCodigo_libro_categoria(int codigo_libro_categoria) {
        this.codigo_libro_categoria = codigo_libro_categoria;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }
}
