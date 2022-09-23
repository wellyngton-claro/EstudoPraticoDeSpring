package br.com.EstudoPraticoDeSpring.Model;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Carrinho {

    @Id
    private Long id;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Produto> listaProdutos;
    private Long total;
}
