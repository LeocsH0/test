package br.com.reciclo.reciclo_backend.respositories;

import br.com.reciclo.reciclo_backend.model.Coleta;
import br.com.reciclo.reciclo_backend.model.Residuos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResiduosRepository extends JpaRepository<Residuos,Long> {

}
