package cl.DBD.ejemplo.Models;

public class Permiso {
    private int codigo_permiso;
    private int codigo_tipo_usuario;

    public Permiso(int codigo_permiso, int codigo_tipo_usuario) {
        this.codigo_permiso = codigo_permiso;
        this.codigo_tipo_usuario = codigo_tipo_usuario;
    }

    public int getCodigo_permiso() {
        return codigo_permiso;
    }

    public void setCodigo_permiso(int codigo_permiso) {
        this.codigo_permiso = codigo_permiso;
    }

    public int getCodigo_tipo_usuario() {
        return codigo_tipo_usuario;
    }

    public void setCodigo_tipo_usuario(int codigo_tipo_usuario) {
        this.codigo_tipo_usuario = codigo_tipo_usuario;
    }
}
