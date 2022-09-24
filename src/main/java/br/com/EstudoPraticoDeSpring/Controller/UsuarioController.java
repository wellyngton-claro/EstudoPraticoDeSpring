package br.com.EstudoPraticoDeSpring.Controller;

import br.com.EstudoPraticoDeSpring.DTO.UsuarioDto;
import br.com.EstudoPraticoDeSpring.Service.UsuarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/cadastro")
    public UsuarioDto cadastrar(@RequestBody UsuarioDto usuarioDto) {
        return this.usuarioService.cadastrar(usuarioDto);
    }

    @PutMapping("/{id}/atualizar")
    public UsuarioDto atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto) {
        return this.usuarioService.atualizar(id, usuarioDto);
    }

    @DeleteMapping("/")
    public UsuarioDto remover(@RequestBody @NotNull UsuarioDto usuarioDto) {
        return this.usuarioService.remover(usuarioDto);
    }

    @GetMapping("/{id}")
    public UsuarioDto buscarPorId(@PathVariable("id") Long id) {
        return this.usuarioService.buscarPorId(id);
    }

    @GetMapping("/lista")
    public List<UsuarioDto> listar() {
        return this.usuarioService.listar();
    }
}
