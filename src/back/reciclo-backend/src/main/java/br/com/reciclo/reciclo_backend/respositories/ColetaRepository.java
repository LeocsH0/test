package br.com.reciclo.reciclo_backend.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reciclo.reciclo_backend.model.Coleta;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta,Long>{
    
}
