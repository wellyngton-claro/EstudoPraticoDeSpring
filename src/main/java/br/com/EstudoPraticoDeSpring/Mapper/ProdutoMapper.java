package br.com.EstudoPraticoDeSpring.Mapper;

import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Model.Produto;

public class ProdutoMapper {

    public Produto DTOparaEntidade (ProdutoDto produtoDto){
        if(produtoDto.getId()!=null) {
            Produto produto = new Produto()
                    .setId(produtoDto.getId())
                    .setNome(produtoDto.getNome())
                    .setDescricao(produtoDto.getDescricao())
                    .setQuantidade(produtoDto.getQuantidade())
                    .setValor(produtoDto.getValor());
            return produto;
        }
        return null;
    }

    public ProdutoDto entidadeParaDTO(Produto produto){
        if(produto.getId()!=null){
            ProdutoDto produtoDto = new ProdutoDto()
                    .setId(produto.getId())
                    .setNome(produto.getNome())
                    .setDescricao(produto.getDescricao())
                    .setQuantidade(produto.getQuantidade())
                    .setValor(produto.getValor())
                    .setIdCarrinho(produto.getCarrinho().getId());
            return produtoDto;
        }
        return null;
    }

}
