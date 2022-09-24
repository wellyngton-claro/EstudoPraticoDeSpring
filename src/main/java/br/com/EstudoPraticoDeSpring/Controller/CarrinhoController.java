package br.com.EstudoPraticoDeSpring.Controller;


import br.com.EstudoPraticoDeSpring.DTO.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.Service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Controller
public class CarrinhoController{

    @Autowired
    private CarrinhoService carrinhoService;
    @PostMapping("/criar-carrinho")
    public CarrinhoDto registarCarrinho(@RequestBody CarrinhoDto carrinhoDto){
        return this.carrinhoService.registarCarrinho(carrinhoDto);
    }

    @GetMapping("/carrinho")
    public CarrinhoDto conferirCarrinho(@RequestBody Long id){
        return this.carrinhoService.conferirCarrinho(id);
    }

    @PutMapping("/produtos/{id}")
    public CarrinhoDto adicionarProdutoAoCarrinho(@PathVariable Long idProduto, @RequestBody CarrinhoDto carrinhoDto){
        return this.carrinhoService.adicionarProdutoAoCarrinho(idProduto, carrinhoDto);
    }

    @GetMapping("/{id}/carrinho")
    public CarrinhoDto buscarCarrinhoPorUsuario(@PathVariable("id") Long id){
        return this.carrinhoService.buscarCarrinhoPorUsuario(id);
    }
}