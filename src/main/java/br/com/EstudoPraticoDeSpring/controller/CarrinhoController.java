package br.com.EstudoPraticoDeSpring.controller;


import br.com.EstudoPraticoDeSpring.dto.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.model.Carrinho;
import br.com.EstudoPraticoDeSpring.model.Produto;
import br.com.EstudoPraticoDeSpring.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @PostMapping
    public Carrinho registarCarrinho(@RequestBody CarrinhoDto carrinhoDto){
        if(!this.validarCarrinho(carrinhoDto.getId())){
            return  carrinhoDto.builder()
                    .setId(carrinhoDto.getId())
                    .setUsuario(carrinhoDto.getUsuario());
        }
        return null;
    }

    @GetMapping("/carrinho")
    public Carrinho conferirCarrinho(@RequestBody Long id){
        if(this.validarCarrinho(id)){
            return carrinhoRepository.findById(id).get();
        }
        return null;
    }

    @PutMapping("/")
    public Carrinho atualizarCarrinho(@RequestBody Long id, @RequestBody Produto produto){
        if(this.validarCarrinho(id)){
            Optional<Carrinho> carrinho =carrinhoRepository.findById(id);
            carrinho.get()
                    .getListaProdutos()
                    .add(produto);
            return this.carrinhoRepository.save(carrinho.get());
        }
        return null;
    }

    public boolean validarCarrinho(Long id){
        Optional<Carrinho> carrinhoValidado = carrinhoRepository.findById(id);
        if (carrinhoValidado.isPresent()){
            return true;
        }
        return false;
    }

    public Long totalCarrinho(Long id){
        return null;
    }

}
