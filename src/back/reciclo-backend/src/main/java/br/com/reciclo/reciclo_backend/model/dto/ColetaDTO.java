package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;

public record ColetaDTO(
    Long id,
    // Residuo residuo,
    StatusColeta status){

    public long getId(){
        return id;
    }
}
    

