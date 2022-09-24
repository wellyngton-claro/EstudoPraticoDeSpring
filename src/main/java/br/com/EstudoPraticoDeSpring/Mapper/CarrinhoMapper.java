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
            Carrinho carrinho = new Carrinho()
                    .setId(carrinhoDto.getId())
                    .setUsuario(usuarioMapper
                            .DTOparaEntidade(usuarioService
                                    .buscarPorId(carrinhoDto.getIdUsuario())));
            return carrinho;
        }
        return null;
    }
    public CarrinhoDto entidadeParaDTO(Carrinho carrinho){
        if (carrinho.getId()!=null){
            CarrinhoDto carrinhoDto = new CarrinhoDto()
                    .setId(carrinho.getId())
                    .setIdUsuario(carrinho.getUsuario().getId());
            return carrinhoDto;
        }
        return null;
    }

}
