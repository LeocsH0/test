package br.com.reciclo.reciclo_backend.model.dto;

import br.com.reciclo.reciclo_backend.model.enums.TipoUsuario;

public record RegisterDTO(String name, String password, String email, String cellphone, TipoUsuario type) {

}
