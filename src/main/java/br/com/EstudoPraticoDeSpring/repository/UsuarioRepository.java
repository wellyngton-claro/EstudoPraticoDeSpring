package br.com.EstudoPraticoDeSpring.repository;

import br.com.EstudoPraticoDeSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}