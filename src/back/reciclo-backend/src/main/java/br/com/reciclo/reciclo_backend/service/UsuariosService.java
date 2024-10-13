package br.com.reciclo.reciclo_backend.service;

import org.springframework.stereotype.Service;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.respositories.UsuariosRepository;

@Service
public class UsuariosService {
    private final UsuariosRepository userRepository;

    public UsuariosService(UsuariosRepository userRepository){
        this.userRepository = userRepository;
    }

    public Usuarios criarUsuario(Usuarios userRequestDto){
        Usuarios userResponse = null;
        Usuarios user = new Usuarios(userRequestDto.getName(), userRequestDto.getPassword(), userRequestDto.getEmail(), userRequestDto.getCellphone(), userRequestDto.getType());

        try {
            userResponse  = this.userRepository.save(user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return userResponse;
    }
}
