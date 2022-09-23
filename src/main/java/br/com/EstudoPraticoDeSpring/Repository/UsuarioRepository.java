package br.com.EstudoPraticoDeSpring.Repository;

import br.com.EstudoPraticoDeSpring.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}