package br.com.reciclo.reciclo_backend.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.reciclo.reciclo_backend.model.Usuarios;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {
    
}
