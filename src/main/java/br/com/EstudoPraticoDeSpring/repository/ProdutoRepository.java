package br.com.EstudoPraticoDeSpring.repository;

import br.com.EstudoPraticoDeSpring.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}