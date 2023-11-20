package br.rsea.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.rsea.model.Usuario;

public class MyUserDetails implements UserDetails{
    private Usuario usuarioDoSistema;

    public MyUserDetails(Usuario usuario) {
        this.usuarioDoSistema = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.usuarioDoSistema.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarioDoSistema.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
