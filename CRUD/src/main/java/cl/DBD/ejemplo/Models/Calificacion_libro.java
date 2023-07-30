package cl.DBD.ejemplo.Models;

public class Calificacion_libro {
    private int codigo_calificacion;
    private int codigo_usuario;
    private int id_libro;
    private int valoracion;

    public Calificacion_libro(int codigo_calificacion, int codigo_usuario, int id_libro, int valoracion) {
        this.codigo_calificacion = codigo_calificacion;
        this.codigo_usuario = codigo_usuario;
        this.id_libro = id_libro;
        this.valoracion = valoracion;
    }

    public int getCodigo_calificacion() {
        return codigo_calificacion;
    }

    public void setCodigo_calificacion(int codigo_calificacion) {
        this.codigo_calificacion = codigo_calificacion;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
