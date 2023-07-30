package cl.DBD.ejemplo.Models;

public class Tipo_usuario {

    private int codigo_tipo_usuario;
    private String nombre_tipo_usuario;
    private int codigo_usuario;

    public Tipo_usuario(int codigo_tipo_usuario, String nombre_tipo_usuario, int codigo_usuario) {
        this.codigo_tipo_usuario = codigo_tipo_usuario;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
        this.codigo_usuario = codigo_usuario;
    }

    public int getCodigo_tipo_usuario() {
        return codigo_tipo_usuario;
    }

    public void setCodigo_tipo_usuario(int codigo_tipo_usuario) {
        this.codigo_tipo_usuario = codigo_tipo_usuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
}
