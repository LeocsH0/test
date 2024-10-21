package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.Coleta;

public record EnderecoDTO(ColetaDTO coleta,
                          String logradouro,
                          String numero,
                          String complemento,
                          String bairro,
                          String cidade,
                          String estado,
                          String cep) {
}
