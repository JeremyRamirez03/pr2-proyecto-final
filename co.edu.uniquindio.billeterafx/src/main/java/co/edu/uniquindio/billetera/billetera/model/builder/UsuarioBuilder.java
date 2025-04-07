package co.edu.uniquindio.billetera.billetera.model.builder;

import co.edu.uniquindio.billetera.billetera.model.Usuario;

public class UsuarioBuilder {
    protected String nombre;
    protected String apellido;
    protected String idUsuario;
    protected String email;
    protected String telefonoCelular;
    protected String direccion;
    protected int saldoTotalDisponible;

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioBuilder idUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder telefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
        return this;
    }

    public UsuarioBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public UsuarioBuilder saldoTotalDisponible(int saldoTotalDisponible) {
        this.saldoTotalDisponible = saldoTotalDisponible;
        return this;
    }

    public Usuario build() {
        return new Usuario(nombre,apellido,idUsuario,email,telefonoCelular,direccion,saldoTotalDisponible);
    }
}
