package br.com.EstudoPraticoDeSpring.Service;

import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@Controller
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/cadastro")
    public ProdutoDto cadastro(@RequestBody ProdutoDto produtoDto){
        if(!this.verificarProduto(produtoDto.getId())){
            return produtoRepository.save(produtoDto));
        }
        return null;
    }

    @PutMapping("/{id}/atualizar")
    public ProdutoDto atualizar(@PathVariable("id") Long id, @RequestBody ProdutoDto produtoDto){
        if(this.verificarProduto(id)){
            Optional<ProdutoDto> produto = this.produtoRepository.findById(id);
            produto.get()
                    .setNome(produtoDto.getNome())
                    .setDescricao(produtoDto.getDescricao())
                    .setValor(produtoDto.getValor());
            return this.produtoRepository.save(produto.get());
        }
        return null;
    }

    @DeleteMapping("/")
    public ProdutoDto remover(@RequestBody ProdutoDto produtoDto){
        if(this.verificarProduto(produtoDto.getId())){
            Optional<ProdutoDto> produto = produtoRepository.findById(produtoDto.getId());
            produtoRepository.delete(produto.get());
            return produto.get();
        }
        return null;
    }

    @GetMapping("/{id}")
    public ProdutoDto buscarPorId(@PathVariable("id") Long id){
        if(this.verificarProduto(id)){
            return produtoRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("")
    public List<ProdutoDto> listar(){
        return produtoRepository.findAll();
    }

    public boolean verificarProduto(Long id){
        Optional<ProdutoDto> produtoValido = produtoRepository.findById(id);
        if(produtoValido.isPresent()){
            return true;
        }
        return false;
    }

}
