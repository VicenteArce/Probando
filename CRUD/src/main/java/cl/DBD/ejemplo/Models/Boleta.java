package cl.DBD.ejemplo.Models;

public class Boleta {
    private int codigo_boleta;
    private String tipo_de_pago;
    private int codigo_carrito;

    public Boleta(int codigo_boleta, String tipo_de_pago, int codigo_carrito) {
        this.codigo_boleta = codigo_boleta;
        this.tipo_de_pago = tipo_de_pago;
        this.codigo_carrito = codigo_carrito;
    }

    public int getCodigo_boleta() {
        return codigo_boleta;
    }

    public void setCodigo_boleta(int codigo_boleta) {
        this.codigo_boleta = codigo_boleta;
    }

    public String getTipo_de_pago() {
        return tipo_de_pago;
    }

    public void setTipo_de_pago(String tipo_de_pago) {
        this.tipo_de_pago = tipo_de_pago;
    }

    public int getCodigo_carrito() {
        return codigo_carrito;
    }

    public void setCodigo_carrito(int codigo_carrito) {
        this.codigo_carrito = codigo_carrito;
    }
}
