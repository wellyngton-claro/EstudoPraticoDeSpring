package br.com.EstudoPraticoDeSpring.controller;


import br.com.EstudoPraticoDeSpring.dto.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.model.Carrinho;
import br.com.EstudoPraticoDeSpring.model.Produto;
import br.com.EstudoPraticoDeSpring.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Controller
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private ProdutoController produtoController;
    @Autowired
    private UsuarioController usuarioController;

    @PostMapping
    public Carrinho registarCarrinho(@RequestBody CarrinhoDto carrinhoDto){
        if(!this.verificarCarrinho(carrinhoDto.getId())){
            return  carrinhoDto.builder()
                    .setId(carrinhoDto.getId())
                    .setUsuario(carrinhoDto.getUsuario());
        }
        return null;
    }

    @GetMapping("/carrinho")
    public Carrinho conferirCarrinho(@RequestBody Long id){
        if(this.verificarCarrinho(id)){
            return carrinhoRepository.findById(id).get();
        }
        return null;
    }

    @PutMapping("/")
    public Carrinho adicionarProdutoAoCarrinho(@RequestBody Long id, @RequestBody Produto produto){
        if(this.verificarCarrinho(id)){
            if(produtoController.verificarProduto(produto.getId())){
                Optional<Carrinho> carrinho =carrinhoRepository.findById(id);
                carrinho.get()
                        .getListaProdutos()
                        .add(produto);
                carrinho.get().setTotal(this.atualizarTotalCarrinho(id));
                return this.carrinhoRepository.save(carrinho.get());
            }
            return null;
        }
        return null;
    }

    @GetMapping("/{id}/carrinho")
    public Carrinho buscarCarrinhoPorUsuario(@PathVariable("id") Long id){
        if(this.usuarioController.verificarUsuario(id)){
            return carrinhoRepository.buscarPorUsuario(id).get();
        }
        return null;
    }

    public boolean verificarCarrinho(Long id){
        Optional<Carrinho> carrinhoValidado = carrinhoRepository.findById(id);
        if (carrinhoValidado.isPresent()){
            return true;
        }
        return false;
    }

    public Long atualizarTotalCarrinho(Long id){
        if(this.verificarCarrinho(id)){
            List<Produto> produtos = carrinhoRepository.findById(id).get().getListaProdutos();
            return produtos.stream()
                    .mapToLong(produto -> produto.getValor()*produto.getQuantidade())
                    .sum();
        }
        return null;
    }
}
