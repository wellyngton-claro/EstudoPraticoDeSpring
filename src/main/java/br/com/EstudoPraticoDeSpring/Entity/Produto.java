package br.com.EstudoPraticoDeSpring.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
