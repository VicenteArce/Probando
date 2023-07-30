package cl.DBD.ejemplo.Models;

public class Carrito_de_compras {
    private int codigo_carrito;

    private int codigo_usuario;

    public Carrito_de_compras(int codigo_carrito, int codigo_usuario) {
        this.codigo_carrito = codigo_carrito;
        this.codigo_usuario = codigo_usuario;
    }

    public int getCodigo_carrito() {
        return codigo_carrito;
    }

    public void setCodigo_carrito(int codigo_carrito) {
        this.codigo_carrito = codigo_carrito;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
}
