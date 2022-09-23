package br.com.EstudoPraticoDeSpring.Model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Produto {

    @Id
    private Long id;
    private String nome;
    private String descricao;
    private Long valor;
    private Long quantidade;
    @ManyToOne
    private Carrinho carrinho;
}
