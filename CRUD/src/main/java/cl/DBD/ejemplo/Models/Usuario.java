package cl.DBD.ejemplo.Models;

import java.util.Date;

public class Usuario {
    private int codigo_usuario;
    private String nombre_usuarios;
    private Date fecha_nacimiento;
    private String email_usuario;
    private String contrasena;
    private String ubicacion_geografica;



    public Usuario(int codigo_usuario, String nombre_usuarios, Date fecha_nacimiento, String email_usuario, String contrasena, String ubicacion_geografica) {
        this.codigo_usuario = codigo_usuario;
        this.nombre_usuarios = nombre_usuarios;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email_usuario = email_usuario;
        this.contrasena = contrasena;
        this.ubicacion_geografica = ubicacion_geografica;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }
    public String getNombre_usuario() {return nombre_usuarios;}

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public String getEmail_usuario() {return email_usuario;}

    public String getContrasena() {return contrasena;}

    public String getUbicacion_geografica(){return ubicacion_geografica;}

    public void setId_usuario(int codigo_usuario) {this.codigo_usuario = codigo_usuario;}

    public void setNombre_usuario(String nombre_usuarios){this.nombre_usuarios = nombre_usuarios;}

    public void setFecha_nacimiento(Date fecha_nacimiento){this.fecha_nacimiento = fecha_nacimiento;}

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setUbicacion_geografica(String ubicacion_geografica) {
        this.ubicacion_geografica = ubicacion_geografica;
    }
}
