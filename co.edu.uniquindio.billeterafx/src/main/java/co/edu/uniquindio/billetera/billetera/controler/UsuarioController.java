package co.edu.uniquindio.billetera.billetera.controler;

import co.edu.uniquindio.billetera.billetera.factory.ModelFactory;
import co.edu.uniquindio.billetera.billetera.mapping.dto.UsuarioDto;

import java.util.List;

public class UsuarioController {
    ModelFactory modelFactory;
    public UsuarioController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return modelFactory.agregarUsuario(usuarioDto);
    }
}
