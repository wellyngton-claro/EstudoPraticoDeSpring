package br.com.EstudoPraticoDeSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.Model.Carrinho} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDto {
    private Long id;
    private Long idUsuario;

}