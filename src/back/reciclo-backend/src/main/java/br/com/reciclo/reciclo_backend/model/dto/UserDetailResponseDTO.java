package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.model.enums.TipoUsuario;

import java.util.List;

public record UserDetailResponseDTO(String name, String email, String cellphone, TipoUsuario type) {

}
