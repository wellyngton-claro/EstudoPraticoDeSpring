package br.com.EstudoPraticoDeSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.Model.Usuario} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto implements Serializable {
    private Long id;
    private String nome;
    private String senha;
    private Long idCarinho;
}