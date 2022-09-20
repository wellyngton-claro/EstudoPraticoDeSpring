package br.com.EstudoPraticoDeSpring.controller;

import br.com.EstudoPraticoDeSpring.dto.ProdutoDto;
import br.com.EstudoPraticoDeSpring.model.Produto;
import br.com.EstudoPraticoDeSpring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/cadastro")
    public Produto cadastro(@RequestBody ProdutoDto produtoDto){
        if(!this.verificarProduto(produtoDto.getId())){
            return produtoRepository.save(produtoDto.builder());
        }
        return null;
    }

    @PutMapping("/{id}/atualizar")
    public Produto atualizar(@PathVariable("id") Long id, @RequestBody ProdutoDto produtoDto){
        if(this.verificarProduto(id)){
            Optional<Produto> produto = this.produtoRepository.findById(id);
            produto.get()
                    .setNome(produtoDto.getNome())
                    .setDescricao(produtoDto.getDescricao())
                    .setValor(produtoDto.getValor());
            return this.produtoRepository.save(produto.get());
        }
        return null;
    }

    @DeleteMapping("/")
    public Produto remover(@RequestBody ProdutoDto produtoDto){
        if(this.verificarProduto(produtoDto.getId())){
            Optional<Produto> produto = produtoRepository.findById(produtoDto.getId());
            produtoRepository.delete(produto.get());
            return produto.get();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable("id") Long id){
        if(this.verificarProduto(id)){
            return produtoRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("")
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public boolean verificarProduto(Long id){
        Optional<Produto> produtoValido = produtoRepository.findById(id);
        if(produtoValido.isPresent()){
            return true;
        }
        return false;
    }

}
