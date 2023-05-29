package br.com.EstudoPraticoDeSpring.Repository;

import br.com.EstudoPraticoDeSpring.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}