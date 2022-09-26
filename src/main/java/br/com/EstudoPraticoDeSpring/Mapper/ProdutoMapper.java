package br.com.EstudoPraticoDeSpring.Mapper;

import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Model.Produto;

public class ProdutoMapper {

    public Produto DTOparaEntidade (ProdutoDto produtoDto){
        if(produtoDto.getId()!=null) {
            return Produto.builder()
                    .id(produtoDto.getId())
                    .nome(produtoDto.getNome())
                    .descricao(produtoDto.getDescricao())
                    .quantidade(produtoDto.getQuantidade())
                    .valor(produtoDto.getValor())
                    .build();
        }
        return null;
    }

    public ProdutoDto entidadeParaDTO(Produto produto){
        if(produto.getId()!=null){
            return ProdutoDto.builder()
                    .id(produto.getId())
                    .nome(produto.getNome())
                    .descricao(produto.getDescricao())
                    .quantidade(produto.getQuantidade())
                    .valor(produto.getValor())
                    .idCarrinho(produto.getCarrinho().getId())
                    .build();
        }
        return null;
    }

}
