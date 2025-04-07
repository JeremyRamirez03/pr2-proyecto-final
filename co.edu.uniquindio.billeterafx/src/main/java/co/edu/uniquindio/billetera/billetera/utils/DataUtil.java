package co.edu.uniquindio.billetera.billetera.utils;

import co.edu.uniquindio.billetera.billetera.model.Billertera;
import co.edu.uniquindio.billetera.billetera.model.Usuario;

public class DataUtil {
    public static Billertera inicializarDatos() {
        Billertera billertera = new Billertera();
        Usuario usuario1 = Usuario.builder()
                .idUsuario("mat568")
                .nombre("Mateo")
                .apellido("Cardona")
                .direccion("armenia")
                .email("j2@gmail")
                .build();

        Usuario usuario2 = Usuario.builder()
                .idUsuario("lucho45")
                .nombre("Luis")
                .apellido("Varon")
                .direccion("armenia")
                .email("j1@gmail")
                .build();

        Usuario usuario3 = Usuario.builder()
                .idUsuario("Kevin789")
                .nombre("Kevin")
                .apellido("Miranda")
                .direccion("armenia")
                .email("j3@gmail")
                .build();

        billertera.getListaUsuarios().add(usuario1);
        billertera.getListaUsuarios().add(usuario2);
        billertera.getListaUsuarios().add(usuario3);

        return billertera;
    }
}
