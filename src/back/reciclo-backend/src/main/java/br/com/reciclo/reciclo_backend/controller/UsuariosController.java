package br.com.reciclo.reciclo_backend.controller;

import br.com.reciclo.reciclo_backend.model.dto.UserDetailResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.model.dto.UserResponseDTO;
import br.com.reciclo.reciclo_backend.service.UsuariosService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService userService;

    @GetMapping()
    public ResponseEntity<UserResponseDTO> buscarUsuarios(){
        List<Usuarios> users = userService.buscarUsuarios();
        return ResponseEntity.ok(new UserResponseDTO(users));
    }

    @GetMapping("/detail")
    public ResponseEntity<UserDetailResponseDTO> buscarUsuarioDetail(Authentication authentication){
        Usuarios user = (Usuarios) authentication.getPrincipal();
        System.out.println(user.getAuthorities());
        UserDetailResponseDTO userResponse = userService.buscarUsuariosPorEmail(user.getEmail());

        return ResponseEntity.ok(userResponse);
    }
}
