package cl.DBD.ejemplo.Models;


public class Libro {
    private int id_libro;
    private String nombre_libro;
    private int precio;
    private int stock;
    private String ubicacion_geografica;
    private int restriccion_de_edad;
    private String url;
    private int codigo_permiso;

    public Libro(int id_libro, String nombre_libro, int precio, int stock, String ubicacion_geografica, int restriccion_de_edad, String url, int codigo_permiso) {
        this.id_libro = id_libro;
        this.nombre_libro = nombre_libro;
        this.precio = precio;
        this.stock = stock;
        this.ubicacion_geografica = ubicacion_geografica;
        this.restriccion_de_edad = restriccion_de_edad;
        this.url = url;
        this.codigo_permiso = codigo_permiso;
    }

    public int getId_libro() {
        return id_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getUbicacion_geografica() {
        return ubicacion_geografica;
    }

    public int getRestriccion_de_edad() {
        return restriccion_de_edad;
    }

    public String getUrl() {
        return url;
    }

    public int getCodigo_permiso() {
        return codigo_permiso;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setUbicacion_geografica(String ubicacion_geografica) {
        this.ubicacion_geografica = ubicacion_geografica;
    }

    public void setRestriccion_de_edad(int restriccion_de_edad) {
        this.restriccion_de_edad = restriccion_de_edad;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCodigo_permiso(int codigo_permiso) {
        this.codigo_permiso = codigo_permiso;
    }
}
