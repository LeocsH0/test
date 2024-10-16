package br.com.reciclo.reciclo_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.reciclo.reciclo_backend.respositories.UsuariosRepository;

@Service
public class AuthorizationService implements UserDetailsService{
    
    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuariosRepository.findByEmail(username);
    }

}
