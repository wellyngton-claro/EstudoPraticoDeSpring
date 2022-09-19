package br.com.EstudoPraticoDeSpring.dto;

import br.com.EstudoPraticoDeSpring.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.EstudoPraticoDeSpring.model.Produto} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto implements Serializable {
    private  Long id;
    private String nome;
    private  String descricao;
    private  Long valor;

    public Produto builder(){
        Produto produto = new Produto()
                .setId(this.id)
                .setNome(this.nome)
                .setDescricao(this.descricao)
                .setValor(this.valor);
        return produto;
    }
}