package co.edu.uniquindio.billetera.billetera.service;

import co.edu.uniquindio.billetera.billetera.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryService {
    List<UsuarioDto> obtenerUsuarios();

    boolean agregarUsuario(UsuarioDto usuarioDto);
}
