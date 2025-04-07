package co.edu.uniquindio.billetera.billetera.mapping.mappers;

import co.edu.uniquindio.billetera.billetera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera.billetera.model.Usuario;
import co.edu.uniquindio.billetera.billetera.service.IBilleteraMapping;

import java.util.ArrayList;
import java.util.List;

public class BillerteraMapping implements IBilleteraMapping {
    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios) {
        if(listaUsuarios == null){
            return null;
        }
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getNombre(),
                usuario.getApellido(),
                usuario.getIdUsuario(),
                usuario.getEmail(),
                usuario.getDireccion());
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .idUsuario(usuarioDto.idUsuario())
                .email(usuarioDto.email())
                .direccion(usuarioDto.direccion())

                .build();
    }

}
