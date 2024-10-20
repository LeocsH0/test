package br.com.reciclo.reciclo_backend.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.reciclo.reciclo_backend.model.Coleta;

@Repository
public interface ColetaRepository extends CrudRepository<Coleta,Long>{
    
}
