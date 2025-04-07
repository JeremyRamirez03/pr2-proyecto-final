package co.edu.uniquindio.billetera.billetera.service;

import co.edu.uniquindio.billetera.billetera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera.billetera.model.Usuario;

import java.util.List;

public interface IBilleteraMapping {
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
}
