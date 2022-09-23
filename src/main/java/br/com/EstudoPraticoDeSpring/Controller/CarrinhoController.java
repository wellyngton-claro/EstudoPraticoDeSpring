package br.com.EstudoPraticoDeSpring.Controller;


import br.com.EstudoPraticoDeSpring.DTO.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Service.CarrinhoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
@Controller
public class CarrinhoController{

    private CarrinhoService carrinhoService;
    @PostMapping("/criar-carrinho")
    public CarrinhoDto registarCarrinho(@RequestBody CarrinhoDto carrinhoDto){
        return carrinhoService.registarCarrinho(carrinhoDto);
    }

    @GetMapping("/")
    public CarrinhoDto conferirCarrinho(@RequestBody Long id){
        return carrinhoService.conferirCarrinho(id);
    }

    @PutMapping("/")
    public CarrinhoDto adicionarProdutoAoCarrinho(@RequestBody ProdutoDto produto){
        return carrinhoService.adicionarProdutoAoCarrinho(produto);
    }

    @GetMapping("/{id}/carrinho")
    public CarrinhoDto buscarCarrinhoPorUsuario(@PathVariable("id") Long id){
        return carrinhoService.buscarCarrinhoPorUsuario(id);
    }
}