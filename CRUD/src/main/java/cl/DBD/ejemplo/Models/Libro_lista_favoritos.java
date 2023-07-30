package cl.DBD.ejemplo.Models;

public class Libro_lista_favoritos {
    private int codigo_lista_libro_favoritos;
    private int codigo_lista_favoritos;
    private int id_libro;

    public Libro_lista_favoritos(int codigo_lista_libro_favoritos, int codigo_lista_favoritos, int id_libro) {
        this.codigo_lista_libro_favoritos = codigo_lista_libro_favoritos;
        this.codigo_lista_favoritos = codigo_lista_favoritos;
        this.id_libro = id_libro;
    }

    public int getCodigo_lista_libro_favoritos() {
        return codigo_lista_libro_favoritos;
    }

    public void setCodigo_lista_libro_favoritos(int codigo_lista_libro_favoritos) {
        this.codigo_lista_libro_favoritos = codigo_lista_libro_favoritos;
    }

    public int getCodigo_listafavoritos() {
        return codigo_lista_favoritos;
    }

    public void setCodigo_listafavoritos(int codigo_listafavoritos) {
        this.codigo_lista_favoritos = codigo_lista_favoritos;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
}
