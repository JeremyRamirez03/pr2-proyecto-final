package co.edu.uniquindio.billetera.billetera.model;

import java.util.ArrayList;
import java.util.List;

public class Billertera {
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Cuenta> listaCuentas = new ArrayList<>();
    List<Transaccion> listaTransaccion = new ArrayList<>();
    List<Presupuesto> listaPresupuesto = new ArrayList<>();
    List<Categoria> listaCategoria = new ArrayList<>();

    private String nombre;

    public Billertera() {
    }

    public boolean crearUsuario(String nombre,
                                String apellido,
                                String idUsuario,
                                String email,
                                String telefonoCelular,
                                String direccion,
                                int saldoTotalDisponible){
        Usuario usuarioEncontrado = obtenerUsuario(idUsuario);
        if(usuarioEncontrado == null){
            Usuario usuario = getBuildUsuario(nombre,apellido,idUsuario,
                    email,telefonoCelular,direccion,saldoTotalDisponible);
            getListaUsuarios().add(usuario);
            return true;
        }else{
            return  false;
        }
    }

    public boolean crearUsuario(Usuario nuevoUsuario){
        Usuario usuarioEncontrado = obtenerUsuario(nuevoUsuario.getIdUsuario());
        if(usuarioEncontrado == null){
            getListaUsuarios().add(nuevoUsuario);
            return true;
        }else{
            return  false;
        }
    }

    private Usuario getBuildUsuario(String nombre,
                                    String apellido,
                                    String idUsuario,
                                    String email,
                                    String telefonoCelular,
                                    String direccion,
                                    int saldoTotalDisponible) {
        return Usuario.builder()
                .nombre(nombre)
                .apellido(apellido)
                .idUsuario(idUsuario)
                .direccion(direccion)
                .email(email)
                .telefonoCelular(telefonoCelular)
                .build();
    }

    private Usuario obtenerUsuario(String idUsuario) {
        Usuario usuario = null;
        for (Usuario usuario1: getListaUsuarios()) {
            if(usuario1.getIdUsuario().equalsIgnoreCase(idUsuario)){
                usuario = usuario1;
                break;
            }
        }
        return usuario;
    }
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
