package br.com.reciclo.reciclo_backend.factory;

import br.com.reciclo.reciclo_backend.model.Residuos;
import br.com.reciclo.reciclo_backend.model.dto.ColetaRequestDTO;

public class ResiduoFactory {
    public static Residuos criar(ColetaRequestDTO dto){
        return new Residuos(
                dto.tipoResiduo(),
                dto.qtdResiduo(),
                dto.undResiduo(),
                dto.descricaoResiduo()
        );
    }
}
