package br.com.reciclo.reciclo_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.respositories.UsuariosRepository;

import java.util.List;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository userRepository;

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

    public List<Usuarios> buscarUsuarios(){
        List<Usuarios> users = null;

        try {
            users = this.userRepository.findAll();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return users;
    }
}
