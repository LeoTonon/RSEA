package br.rsea.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.rsea.model.Usuario;
import br.rsea.repository.UsuarioRepository;

public class MyUserDetailServices implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
    Usuario usuarioCredenciais = usuarioRepository.findByUsername(username);
    if(usuarioCredenciais == null)
        throw new UsernameNotFoundException(username);
    return new MyUserDetails(usuarioCredenciais);
 }
}
