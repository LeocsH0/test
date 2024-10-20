package br.com.reciclo.reciclo_backend.model.dto;

import java.util.List;

import br.com.reciclo.reciclo_backend.model.Usuarios;

public record UserResponseDTO(List<Usuarios> users) {

}
