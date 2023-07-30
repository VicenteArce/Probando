package cl.DBD.ejemplo.Models;

public class Agrega_libro_transaccion {

    private int codigo_agregar_libro;
    private int codigo_carrito;
    private int id_libro;


    public Agrega_libro_transaccion(int codigo_agregar_libro, int codigo_carrito, int id_libro) {
        this.codigo_agregar_libro = codigo_agregar_libro;
        this.codigo_carrito = codigo_carrito;
        this.id_libro = id_libro;
    }

    public void setSerial_alt(int codigo_agregar_libro) {
        this.codigo_agregar_libro = codigo_agregar_libro;
    }

    public void setCodigo_carrito(int codigo_carrito) {
        this.codigo_carrito = codigo_carrito;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getSerial_alt() {
        return codigo_agregar_libro;
    }

    public int getCodigo_carrito() {
        return codigo_carrito;
    }

    public int getId_libro() {
        return id_libro;
    }
}
