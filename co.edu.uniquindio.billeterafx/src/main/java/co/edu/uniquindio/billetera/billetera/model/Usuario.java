package co.edu.uniquindio.billetera.billetera.model;

import co.edu.uniquindio.billetera.billetera.model.builder.UsuarioBuilder;

public class Usuario {
    private String nombre;
    private String apellido;
    private String idUsuario;
    private String email;
    private String telefonoCelular;
    private String direccion;
    private int saldoTotalDisponible;

    public Usuario(String nombre, String apellido,
                   String idUsuario, String email,
                   String telefonoCelular, String direccion,
                   int saldoTotalDisponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.email = email;
        this.telefonoCelular = telefonoCelular;
        this.direccion = direccion;
        this.saldoTotalDisponible = saldoTotalDisponible;
    }

    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getIdUsuario() {return idUsuario;}
    public String getEmail() {return email;}
    public String getTelefonoCelular() {return telefonoCelular;}
    public String getDireccion() {return direccion;}
    public int getSaldoTotalDisponible() {return saldoTotalDisponible;}

}
