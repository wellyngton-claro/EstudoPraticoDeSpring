package br.com.EstudoPraticoDeSpring.Service;

import br.com.EstudoPraticoDeSpring.DTO.UsuarioDto;
import br.com.EstudoPraticoDeSpring.Repository.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioDto cadastrar(@RequestBody UsuarioDto usuarioDto){
        if(!this.verificarUsuario(usuarioDto.getId())){
            return this.usuarioRepository.save(usuarioDto);
        }
        return null;
    }

    public UsuarioDto atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto){
        if(this.verificarUsuario(id)){
           Optional<UsuarioDto> usuario = this.usuarioRepository.findById(id);
           usuario.get()
                  .setNome(usuarioDto.getNome())
                  .setSenha(usuarioDto.getSenha());
            return this.usuarioRepository.save(usuario.get());
        }
        return null;
    }

    public UsuarioDto remover(@RequestBody @NotNull UsuarioDto usuarioDto){
        if (this.verificarUsuario(usuarioDto.getId())){
            Optional<UsuarioDto> usuario = this.usuarioRepository.findById(usuarioDto.getId());
            this.usuarioRepository.delete(usuario.get());
            return usuario.get();
        }
        return null;
    }

    public UsuarioDto buscarPorId(@PathVariable("id") Long id){
        if(this.verificarUsuario(id)){
            return this.usuarioRepository.findById(id).get();
        }
        return null;
    }

    public List<UsuarioDto> listar(){
        return this.usuarioRepository.findAll();
    }

    public boolean verificarUsuario(Long id){
        Optional<UsuarioDto> usuarioVerificado= this.usuarioRepository.findById(id);
        return usuarioVerificado.isPresent();
    }

}
