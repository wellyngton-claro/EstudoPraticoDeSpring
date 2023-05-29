package br.com.EstudoPraticoDeSpring.Service;


import br.com.EstudoPraticoDeSpring.DTO.CarrinhoDto;
import br.com.EstudoPraticoDeSpring.Mapper.CarrinhoMapper;
import br.com.EstudoPraticoDeSpring.Mapper.ProdutoMapper;
import br.com.EstudoPraticoDeSpring.Entity.Carrinho;
import br.com.EstudoPraticoDeSpring.Entity.Produto;
import br.com.EstudoPraticoDeSpring.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CarrinhoMapper carrinhoMapper;
    @Autowired
    private ProdutoMapper produtoMapper;

    public CarrinhoDto registarCarrinho(CarrinhoDto carrinhoDto){
        if(!verificarCarrinho(carrinhoDto.getId())){
            this.carrinhoRepository.save(this.carrinhoMapper.DTOparaEntidade(carrinhoDto));
            return carrinhoDto;
        }
        return null;
    }

    public CarrinhoDto buscarCarrinhoPorId(Long id){
        if(this.verificarCarrinho(id)){
            return this.carrinhoMapper.entidadeParaDTO(carrinhoRepository.findById(id).get());
        }
        return null;
    }

    public CarrinhoDto adicionarProdutoAoCarrinho(Long idProduto, CarrinhoDto carrinhoDto){
        if(this.verificarCarrinho(carrinhoDto.getId())){
            if(this.produtoService.verificarProduto(idProduto)){
                Optional<Carrinho> carrinho = this.carrinhoRepository.findById(carrinhoDto.getId());
                carrinho.get()
                        .getListaProdutos()
                        .add(produtoMapper.DTOparaEntidade(this.produtoService.buscarPorId(idProduto)));
                carrinho.get().setTotal(this.atualizarTotalCarrinho(carrinhoDto.getId()));
                this.carrinhoRepository.save(carrinho.get());
                return carrinhoDto;
            }
            return null;
        }
        return null;
    }

    public CarrinhoDto buscarCarrinhoPorUsuario(Long id){
        if(this.usuarioService.verificarUsuario(id)){
            return this.carrinhoMapper.entidadeParaDTO(this.carrinhoRepository.buscarPorUsuario(id).get());
        }
        return null;
    }

    public boolean verificarCarrinho(Long id){
        Optional<Carrinho> carrinhoValidado = this.carrinhoRepository.findById(id);
        if (carrinhoValidado.isPresent()){
            return true;
        }
        return false;
    }

    public Long atualizarTotalCarrinho(Long id){
        if(this.verificarCarrinho(id)){
            List<Produto> produtos = this.carrinhoRepository.findById(id).get().getListaProdutos();
            return produtos.stream()
                    .mapToLong(produto -> produto.getValor()*produto.getQuantidade())
                    .sum();
        }
        return null;
    }
}
