package br.com.reciclo.reciclo_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.service.UsuariosService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService userService;

    @PostMapping()
    public ResponseEntity<Usuarios> criarUsuario(@RequestBody Usuarios user){
        Usuarios userCreated = userService.criarUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping()
    public ResponseEntity<List<Usuarios>> buscarUsuarios(){
        List<Usuarios> users = userService.buscarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
