package cl.DBD.ejemplo.Models;

public class Lista_favoritos {
private int codigo_lista_favoritos;
private int codigo_usuario;

    public Lista_favoritos(int codigo_listafavoritos, int codigo_usuario) {
        this.codigo_lista_favoritos = codigo_listafavoritos;
        this.codigo_usuario = codigo_usuario;
    }

    public int getCodigo_listafavoritos() {
        return codigo_lista_favoritos;
    }

    public void setCodigo_listafavoritos(int codigo_lista_favoritos) {
        this.codigo_lista_favoritos = codigo_lista_favoritos;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
}
