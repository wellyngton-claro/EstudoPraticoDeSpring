package br.com.EstudoPraticoDeSpring.Service;

import br.com.EstudoPraticoDeSpring.DTO.UsuarioDto;
import br.com.EstudoPraticoDeSpring.Mapper.UsuarioMapper;
import br.com.EstudoPraticoDeSpring.Model.Usuario;
import br.com.EstudoPraticoDeSpring.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;


    public UsuarioDto cadastrar(UsuarioDto usuarioDto){
        if(!this.verificarUsuario(usuarioDto.getId())){
            this.usuarioRepository.save(this.usuarioMapper.DTOparaEntidade(usuarioDto));
            return usuarioDto;
        }
        return null;
    }

    public UsuarioDto atualizar(Long id, UsuarioDto usuarioDto){
        if(this.verificarUsuario(id)){
           Optional<Usuario> usuario = this.usuarioRepository.findById(id);
           usuario.get().builder()
                  .nome(usuarioDto.getNome())
                  .senha(usuarioDto.getSenha())
                  .build();
            this.usuarioRepository.save(usuario.get());
            return usuarioDto;
        }
        return null;
    }

    public UsuarioDto remover(UsuarioDto usuarioDto){
        if (this.verificarUsuario(usuarioDto.getId())){
            Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioDto.getId());
            this.usuarioRepository.delete(usuario.get());
            return usuarioDto;
        }
        return null;
    }

    public UsuarioDto buscarPorId(Long id){
        if(this.verificarUsuario(id)){
            return this.usuarioMapper.entidadeParaDTO(this.usuarioRepository.findById(id).get());
        }
        return null;
    }

    public List<UsuarioDto> listar(){
        return this.usuarioRepository.findAll().stream()
                .map(usuario -> this.usuarioMapper.entidadeParaDTO(usuario))
                .collect(Collectors.toList());
    }

    public boolean verificarUsuario(Long id){
        Optional<Usuario> usuarioVerificado= this.usuarioRepository.findById(id);
        return usuarioVerificado.isPresent();
    }

}
