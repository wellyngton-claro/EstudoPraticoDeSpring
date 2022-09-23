package br.com.EstudoPraticoDeSpring.Service;


import br.com.EstudoPraticoDeSpring.DTO.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private UsuarioService usuarioService;

    public CarrinhoDto registarCarrinho(@RequestBody CarrinhoDto carrinhoDto){
        if(!verificarCarrinho(carrinhoDto.getId())){
            return  carrinhoDto
                    .setUsuario(usuarioService.buscarPorId(carrinhoDto.getIdUsuario()));
        }
        return null;
    }

    public CarrinhoDto conferirCarrinho(@RequestBody Long id){
        if(this.verificarCarrinho(id)){
            return carrinhoRepository.findById(id).get();
        }
        return null;
    }

    public CarrinhoDto adicionarProdutoAoCarrinho(@RequestBody ProdutoDto produto){
        if(this.verificarCarrinho(produto.getCarrinho().getId())){
            if(produtoService.verificarProduto(produto.getId())){
                Optional<CarrinhoDto> carrinho =carrinhoRepository.findById(produto.getCarrinho().getId());
                carrinho.get()
                        .getListaProdutos()
                        .add(produto);
                carrinho.get().setTotal(this.atualizarTotalCarrinho(produto.getCarrinho().getId()));
                return this.carrinhoRepository.save(carrinho.get());
            }
            return null;
        }
        return null;
    }

    public CarrinhoDto buscarCarrinhoPorUsuario(@PathVariable("id") Long id){
        if(this.usuarioService.verificarUsuario(id)){
            return carrinhoRepository.buscarPorUsuario(id).get();
        }
        return null;
    }

    public boolean verificarCarrinho(Long id){
        Optional<CarrinhoDto> carrinhoValidado = carrinhoRepository.findById(id);
        if (carrinhoValidado.isPresent()){
            return true;
        }
        return false;
    }

    public Long atualizarTotalCarrinho(Long id){
        if(this.verificarCarrinho(id)){
            List<ProdutoDto> produtos = carrinhoRepository.findById(id).get().getListaProdutos();
            return produtos.stream()
                    .mapToLong(produto -> produto.getValor()*produto.getQuantidade())
                    .sum();
        }
        return null;
    }
}
