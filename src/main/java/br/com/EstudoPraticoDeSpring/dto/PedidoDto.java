package br.com.EstudoPraticoDeSpring.dto;

import br.com.EstudoPraticoDeSpring.model.Produto;
import br.com.EstudoPraticoDeSpring.model.Usuario;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.model.Pedido} entity
 */
@Data
public class PedidoDto implements Serializable {
    private Long id;
    private Usuario usuario;
    private List<Produto> listaProdutos;
}