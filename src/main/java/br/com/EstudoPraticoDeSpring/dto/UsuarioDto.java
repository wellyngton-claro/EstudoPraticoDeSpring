package br.com.EstudoPraticoDeSpring.dto;

import br.com.EstudoPraticoDeSpring.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.model.Usuario} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto implements Serializable {
    private Long id;
    private String nome;
    private String senha;

    public Usuario builder (){
        Usuario usuario = new Usuario()
                .setNome(this.nome)
                .setSenha(this.senha);

        return usuario;
    }

}