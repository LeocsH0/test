package br.com.reciclo.reciclo_backend.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.reciclo.reciclo_backend.model.enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios implements UserDetails{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String cellphone;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoUsuario type;

    public Usuarios(){}

    public Usuarios(String name, String password, String email, String cellphone, TipoUsuario type){
        this.name = name;
        this.email = email;
        this.password = password;
        this.cellphone = cellphone;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getCellphone(){
        return this.cellphone;
    }

    public void setCellphone(String cellphone){
        this.cellphone = cellphone;
    }

    public TipoUsuario getType(){
        return this.type;
    }

    public void setType(TipoUsuario type){
        this.type = type;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.type == TipoUsuario.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
