package br.com.EstudoPraticoDeSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.Model.Carrinho} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CarrinhoDto {
    private Long id;
    private Long idUsuario;

}