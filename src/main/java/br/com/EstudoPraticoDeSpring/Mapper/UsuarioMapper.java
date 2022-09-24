package br.com.EstudoPraticoDeSpring.Mapper;

import br.com.EstudoPraticoDeSpring.DTO.UsuarioDto;
import br.com.EstudoPraticoDeSpring.Model.Usuario;
import br.com.EstudoPraticoDeSpring.Service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;


public class UsuarioMapper {

    @Autowired
    CarrinhoService carrinhoService;
    CarrinhoMapper carrinhoMapper;

    public Usuario DTOparaEntidade(UsuarioDto usuarioDto){
        if(usuarioDto.getId()!=null){
            Usuario usuario = new Usuario()
                    .setId(usuarioDto.getId())
                    .setNome(usuarioDto.getNome())
                    .setSenha(usuarioDto.getSenha())
                    .setCarrinho(carrinhoMapper
                            .DTOparaEntidade(carrinhoService
                                            .conferirCarrinho(usuarioDto.getIdCarinho())));
            return usuario;
        }
        return null;
    }

    public UsuarioDto entidadeParaDTO(Usuario usuario){
        if(usuario.getId()!=null){
            UsuarioDto usuarioDto = new UsuarioDto()
                    .setId(usuario.getId())
                    .setNome(usuario.getNome())
                    .setSenha(usuario.getSenha())
                    .setIdCarinho(usuario.getCarrinho().getId());
            return usuarioDto;
        }
        return null;
    }
}
