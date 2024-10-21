package br.com.reciclo.reciclo_backend.model.dto;

public record ColetaRequestDTO(String logradouro,
                               String numero,
                               String complemento,
                               String bairro,
                               String cidade,
                               String estado,
                               String cep) {
}
