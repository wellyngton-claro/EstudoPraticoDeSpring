package br.com.EstudoPraticoDeSpring.Mapper;

import br.com.EstudoPraticoDeSpring.DTO.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.Model.Carrinho;
import br.com.EstudoPraticoDeSpring.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;


public class CarrinhoMapper {

    @Autowired
    UsuarioService usuarioService;
    UsuarioMapper usuarioMapper;

    public Carrinho DTOparaEntidade(CarrinhoDto carrinhoDto){
        if(carrinhoDto.getId()!=null){
            return Carrinho.builder()
                    .id(carrinhoDto.getId())
                    .usuario(usuarioMapper
                            .DTOparaEntidade(usuarioService
                                    .buscarPorId(carrinhoDto.getIdUsuario())))
                    .build();
        }
        return null;
    }
    public CarrinhoDto entidadeParaDTO(Carrinho carrinho){
        if (carrinho.getId()!=null){
            return CarrinhoDto.builder()
                    .id(carrinho.getId())
                    .idUsuario(carrinho.getUsuario().getId())
                    .build();
        }
        return null;
    }

}
