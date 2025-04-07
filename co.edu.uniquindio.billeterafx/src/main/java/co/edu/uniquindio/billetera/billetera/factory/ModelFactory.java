package co.edu.uniquindio.billetera.billetera.factory;

import co.edu.uniquindio.billetera.billetera.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera.billetera.mapping.mappers.BillerteraMapping;
import co.edu.uniquindio.billetera.billetera.model.Billertera;
import co.edu.uniquindio.billetera.billetera.model.Usuario;
import co.edu.uniquindio.billetera.billetera.service.IBilleteraMapping;
import co.edu.uniquindio.billetera.billetera.service.IModelFactoryService;
import co.edu.uniquindio.billetera.billetera.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private Billertera billertera;
    private IBilleteraMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new BillerteraMapping();
        billertera = DataUtil.inicializarDatos();
    }

    @Override
   public List<UsuarioDto> obtenerUsuarios() {
       return mapper.getUsuariosDto(billertera.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return billertera.crearUsuario(mapper.usuarioDtoToUsuario(usuarioDto));
    }
}
