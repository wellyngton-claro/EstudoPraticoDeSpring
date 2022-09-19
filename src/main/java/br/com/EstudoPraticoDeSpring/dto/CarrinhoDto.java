package br.com.EstudoPraticoDeSpring.dto;

import br.com.EstudoPraticoDeSpring.model.Carrinho;
import br.com.EstudoPraticoDeSpring.model.Produto;
import br.com.EstudoPraticoDeSpring.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.model.Carrinho} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDto implements Serializable {
    private Long id;
    private Usuario usuario;

    public Carrinho builder(){
        Carrinho carrinho = new Carrinho()
                .setId(this.id)
                .setUsuario(this.usuario);
        return carrinho;
    }
}