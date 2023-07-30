package cl.DBD.ejemplo.Models;

public class Historial_libro {
    private int codigo_historial_libro;
    private int id_libro;
    private int codigo_historial;

    public Historial_libro(int codigo_historial_libro, int id_libro, int codigo_historial) {
        this.codigo_historial_libro = codigo_historial_libro;
        this.id_libro = id_libro;
        this.codigo_historial = codigo_historial;
    }

    public int getCodigo_historial_libro() {
        return codigo_historial_libro;
    }

    public void setCodigo_historial_libro(int codigo_historial_libro) {
        this.codigo_historial_libro = codigo_historial_libro;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getCodigo_historial() {
        return codigo_historial;
    }

    public void setCodigo_historial(int codigo_historial) {
        this.codigo_historial = codigo_historial;
    }
}

