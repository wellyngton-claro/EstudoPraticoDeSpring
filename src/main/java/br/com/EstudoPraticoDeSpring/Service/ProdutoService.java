package br.com.EstudoPraticoDeSpring.Service;

import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Mapper.ProdutoMapper;
import br.com.EstudoPraticoDeSpring.Entity.Produto;
import br.com.EstudoPraticoDeSpring.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoDto cadastro(ProdutoDto produtoDto){
        if(!this.verificarProduto(produtoDto.getId())){
            produtoRepository.save(produtoMapper.DTOparaEntidade(produtoDto));
            return produtoDto;
        }
        return null;
    }

    public ProdutoDto atualizar(Long id, ProdutoDto produtoDto){
        if(this.verificarProduto(id)){
            Optional<Produto> produto = this.produtoRepository.findById(id);
            produto.get().builder()
                    .nome(produtoDto.getNome())
                    .descricao(produtoDto.getDescricao())
                    .valor(produtoDto.getValor())
                    .build();
            this.produtoRepository.save(produto.get());
            return produtoDto;
        }
        return null;
    }

    public ProdutoDto remover(ProdutoDto produtoDto){
        if(this.verificarProduto(produtoDto.getId())){
            Optional<Produto> produto = this.produtoRepository.findById(produtoDto.getId());
            this.produtoRepository.delete(produto.get());
            return produtoDto;
        }
        return null;
    }

    public ProdutoDto buscarPorId(Long id){
        if(this.verificarProduto(id)){
            return produtoMapper.entidadeParaDTO(produtoRepository.findById(id).get());
        }
        return null;
    }

    @GetMapping("")
    public List<ProdutoDto> listar(){
        return this.produtoRepository.findAll().stream()
                .map(produto -> produtoMapper.entidadeParaDTO(produto))
                .collect(Collectors.toList());
    }

    public boolean verificarProduto(Long id){
        Optional<Produto> produtoValido = this.produtoRepository.findById(id);
        if(produtoValido.isPresent()){
            return true;
        }
        return false;
    }

}
