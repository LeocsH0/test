package br.com.reciclo.reciclo_backend.service;
import br.com.reciclo.reciclo_backend.model.dto.UserDetailResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import br.com.reciclo.reciclo_backend.model.Residuos;

import java.util.List;

@Service
public class ResiduosService {
    public List<Residuos> buscarResiduos(){
        List<Residuos> residuos = null;

        try {
            residuos = this.ResiduosRepository.findAll();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return residuos;
    }

}
