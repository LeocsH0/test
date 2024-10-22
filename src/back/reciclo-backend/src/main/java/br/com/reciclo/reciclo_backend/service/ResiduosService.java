package br.com.reciclo.reciclo_backend.service;
import br.com.reciclo.reciclo_backend.model.dto.UserDetailResponseDTO;
import br.com.reciclo.reciclo_backend.respositories.ResiduosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import br.com.reciclo.reciclo_backend.model.Residuos;

import java.util.List;

@Service
public class ResiduosService {
    @Autowired
    private ResiduosRepository residuosRepository;

    public Long cadastrarResiduo(Residuos residuoData){
        Residuos residuo = null;

        try {
            residuo = this.residuosRepository.save(residuoData);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return residuo.getId();
    }

    public List<Residuos> buscarResiduos(){
        List<Residuos> residuos = null;

        try {
            residuos = this.residuosRepository.findAll();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return residuos;
    }

}
