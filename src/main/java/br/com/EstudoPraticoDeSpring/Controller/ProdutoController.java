package br.com.EstudoPraticoDeSpring.Controller;

import br.com.EstudoPraticoDeSpring.DTO.ProdutoDto;
import br.com.EstudoPraticoDeSpring.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastro")
    public ProdutoDto cadastro(@RequestBody ProdutoDto produtoDto) {
        return produtoService.cadastro(produtoDto);
    }

    @PutMapping("/{id}/atualizar")
    public ProdutoDto atualizar(@PathVariable("id") Long id, @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizar(id, produtoDto);
    }

    @DeleteMapping("/")
    public ProdutoDto remover(@RequestBody ProdutoDto produtoDto) {
        return produtoService.remover(produtoDto);
    }

    @GetMapping("/{id}")
    public ProdutoDto buscarPorId(@PathVariable("id") Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("")
    public List<ProdutoDto> listar() {
        return produtoService.listar();
    }
}
