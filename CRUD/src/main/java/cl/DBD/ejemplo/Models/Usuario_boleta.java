package cl.DBD.ejemplo.Models;

public class Usuario_boleta {
    private int codigo_usuario_boleta;
    private int codigo_boleta;
    private int codigo_usuario;

    public Usuario_boleta(int codigo_usuario_boleta, int codigo_boleta, int codigo_usuario) {
        this.codigo_usuario_boleta = codigo_usuario_boleta;
        this.codigo_boleta = codigo_boleta;
        this.codigo_usuario = codigo_usuario;
    }

    public int getCodigo_usuario_boleta() {
        return codigo_usuario_boleta;
    }

    public void setCodigo_usuario_boleta(int codigo_usuario_boleta) {
        this.codigo_usuario_boleta = codigo_usuario_boleta;
    }

    public int getCodigo_boleta() {
        return codigo_boleta;
    }

    public void setCodigo_boleta(int codigo_boleta) {
        this.codigo_boleta = codigo_boleta;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
}
