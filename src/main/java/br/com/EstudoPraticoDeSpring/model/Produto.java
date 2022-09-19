package br.com.EstudoPraticoDeSpring.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
