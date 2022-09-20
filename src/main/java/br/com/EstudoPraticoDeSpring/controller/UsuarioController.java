package br.com.EstudoPraticoDeSpring.controller;

import br.com.EstudoPraticoDeSpring.dto.UsuarioDto;
import br.com.EstudoPraticoDeSpring.model.Usuario;
import br.com.EstudoPraticoDeSpring.repository.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody UsuarioDto usuarioDto){
        if(!this.verificarUsuario(usuarioDto.getId())){
            return this.usuarioRepository.save(usuarioDto.builder());
        }
        return null;
    }

    @PutMapping("/{id}/atualizar")
    public Usuario atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto){
        if(this.verificarUsuario(id)){
           Optional<Usuario> usuario = this.usuarioRepository.findById(id);
           usuario.get()
                  .setNome(usuarioDto.getNome())
                  .setSenha(usuarioDto.getSenha());
            return this.usuarioRepository.save(usuario.get());
        }
        return null;
    }

    @DeleteMapping("/")
    public Usuario remover(@RequestBody @NotNull UsuarioDto usuarioDto){
        if (this.verificarUsuario(usuarioDto.getId())){
            Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioDto.getId());
            this.usuarioRepository.delete(usuario.get());
            return usuario.get();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id){
        if(this.verificarUsuario(id)){
            return this.usuarioRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("/lista")
    public List<Usuario> listar(){
        return this.usuarioRepository.findAll();
    }


    public boolean verificarUsuario(Long id){
        Optional<Usuario> usuarioVerificado= this.usuarioRepository.findById(id);
        return usuarioVerificado.isPresent();
    }

}
