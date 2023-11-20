package br.rsea.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.rsea.model.Usuario;

@Configuration
public class LoadDataInDb implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        ArrayList<Usuario> usuariosNovos = new ArrayList<>();
        Usuario user = new Usuario();
        user.setUsername("orion");
        user.setPassword(passwordEncoder.encode("1234"));
        usuariosNovos.add(user);
        
        usuarioRepository.saveAll(usuariosNovos);
    }
}
