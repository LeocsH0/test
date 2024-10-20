package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;

public record ColetaDTO(
    Long id,
    UserDetailResponseDTO produtor,
    UserDetailResponseDTO coletor,
    // Residuo residuo,
    StatusColeta status){

    public long getId(){
        return id;
    }

    public UserDetailResponseDTO getProdutor(){
        return produtor;
    }

    public UserDetailResponseDTO getColetor(){
        return coletor;
    }
}
    

