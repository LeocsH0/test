package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.enums.TiposDeResiduos;

public record ColetaRequestDTO(String logradouro,
                               String numero,
                               String complemento,
                               String bairro,
                               String cidade,
                               String estado,
                               String cep,
                               TiposDeResiduos tipoResiduo,
                               String descricaoResiduo,
                               Integer qtdResiduo,
                               String undResiduo
) {
}
