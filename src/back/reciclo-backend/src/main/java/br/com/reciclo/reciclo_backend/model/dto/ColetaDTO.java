package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.Endereco;
import br.com.reciclo.reciclo_backend.model.Residuos;
import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;

public record ColetaDTO(
        Long id,
        String produtor,
        StatusColeta status,
        Residuos residuo,
        Endereco endereco){
}
    

