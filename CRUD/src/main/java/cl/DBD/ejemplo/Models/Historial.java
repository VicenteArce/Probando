package cl.DBD.ejemplo.Models;

public class Historial {
    private int codigo_historial;
    private int codigo_usuario;

    public Historial(int codigo_historial, int codigo_usuario) {
        this.codigo_historial = codigo_historial;
        this.codigo_usuario = codigo_usuario;
    }

    public int getCodigo_historial() {
        return codigo_historial;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }


    public void setCodigo_historial(int codigo_historial) {
        this.codigo_historial = codigo_historial;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
}
