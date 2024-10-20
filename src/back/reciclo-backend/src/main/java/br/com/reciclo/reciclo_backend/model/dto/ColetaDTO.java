package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;

public record ColetaDTO(
    Long id,
    UserDetailResponseDTO produtor,
    UserDetailResponseDTO colertor,
    // Residuo residuo,
    StatusColeta status

    ) {
    
};
