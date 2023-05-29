package br.com.EstudoPraticoDeSpring.Mapper;

import br.com.EstudoPraticoDeSpring.DTO.UsuarioDto;
import br.com.EstudoPraticoDeSpring.Entity.Usuario;
import br.com.EstudoPraticoDeSpring.Service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;


public class UsuarioMapper {

    @Autowired
    CarrinhoService carrinhoService;
    CarrinhoMapper carrinhoMapper;

    public Usuario DTOparaEntidade(UsuarioDto usuarioDto){
        if(usuarioDto.getId()!=null){
            return Usuario.builder()
                    .id(usuarioDto.getId())
                    .nome(usuarioDto.getNome())
                    .senha(usuarioDto.getSenha())
                    .carrinho(carrinhoMapper
                            .DTOparaEntidade(carrinhoService
                                            .buscarCarrinhoPorId(usuarioDto.getIdCarinho())))
                    .build();
        }
        return null;
    }

    public UsuarioDto entidadeParaDTO(Usuario usuario){
        if(usuario.getId()!=null){
            return UsuarioDto.builder()
                    .id(usuario.getId())
                    .nome(usuario.getNome())
                    .senha(usuario.getSenha())
                    .idCarinho(usuario.getCarrinho().getId())
                    .build();
        }
        return null;
    }
}
