package br.com.reciclo.reciclo_backend.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.reciclo.reciclo_backend.model.Usuarios;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByEmail(String email);
}
