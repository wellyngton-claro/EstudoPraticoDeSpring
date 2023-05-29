package br.com.EstudoPraticoDeSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.Entity.Carrinho} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarrinhoDto {
    private Long id;
    private Long idUsuario;

}