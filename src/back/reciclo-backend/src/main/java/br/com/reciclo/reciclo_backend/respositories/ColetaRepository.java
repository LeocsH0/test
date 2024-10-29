package br.com.reciclo.reciclo_backend.respositories;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reciclo.reciclo_backend.model.Coleta;

import java.util.List;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta,Long>{
    List<Coleta> findByStatus(StatusColeta status);
}
