package br.com.reciclo.reciclo_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.service.UsuariosService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    private final UsuariosService userService;

    public UsuariosController(UsuariosService userService){
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Usuarios> criarUsuario(@RequestBody Usuarios user){
        Usuarios userDto = userService.criarUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
}
