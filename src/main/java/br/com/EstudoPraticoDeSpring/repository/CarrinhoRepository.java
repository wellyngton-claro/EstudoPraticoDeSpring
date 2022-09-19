package br.com.EstudoPraticoDeSpring.repository;

import br.com.EstudoPraticoDeSpring.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}