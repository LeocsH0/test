package br.com.reciclo.reciclo_backend.service;

import org.springframework.stereotype.Service;

import br.com.reciclo.reciclo_backend.model.Coleta;
import br.com.reciclo.reciclo_backend.respositories.ColetaRepository;

@Service
public class ColetaService {
    private final ColetaRepository coletaRepository;

    public ColetaService(ColetaRepository coletaRepository){
        this.coletaRepository = coletaRepository;
    }

    public Coleta criarColeta(Coleta userRequestDto){
        Coleta coletaResponse = null;
        Coleta user = new Coleta(userRequestDto.getName(), userRequestDto.getPassword(), userRequestDto.getEmail(), userRequestDto.getCellphone(), userRequestDto.getType());

        try {
            coletaResponse  = this.coletaRepository.save(user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return coletaResponse
    }
}