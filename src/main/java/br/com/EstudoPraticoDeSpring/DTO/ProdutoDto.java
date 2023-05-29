package br.com.EstudoPraticoDeSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.Entity.Produto} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDto implements Serializable {
    private Long id;
    private String nome;
    private String descricao;
    private Long valor;
    private Long quantidade;
    private Long idCarrinho;
}