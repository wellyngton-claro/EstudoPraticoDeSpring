package br.com.EstudoPraticoDeSpring.repository;

import br.com.EstudoPraticoDeSpring.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    @Query(value = "SELECT * FROM CARRINHO c LEFT JOIN USUARIO u ON c.USUARIO_ID=u.ID WHERE u.ID=?1",nativeQuery = true)
    Optional<Carrinho> buscarPorUsuario(Long id);
}