package br.rsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.rsea.model.Moderador;
import br.rsea.model.Usuario;
import br.rsea.repository.UsuarioRepository;
import br.rsea.repository.ModeradorRepository;


@RestController
public class CadastroController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ModeradorRepository moderadorRepository;

    @GetMapping("/listar/moderadores")
    public List<Moderador> getModeradores(){
        return (List<Moderador>)moderadorRepository.findAll();
    }

    @PostMapping("/criar/usuario")
    String newUsuario(@RequestBody Usuario newUsuario){
        newUsuario.setPassword(
            passwordEncoder.encode(newUsuario.getPassword())
        );
        Usuario usuCriado = usuarioRepository.save(newUsuario);

        if(usuCriado != null)
            return "Usuário criado com sucesso!";

        return "Erro ao criar o usuário";
    }

    @GetMapping("/listar/usuarios")
    public List<Usuario> getUsuarios(){
        return (List<Usuario>)usuarioRepository.findAll();
    }

    @PutMapping("/moderador/{id}")
    Moderador newModerador(@PathVariable int id){
        Usuario usuario = (usuarioRepository.findById(id)).get();
        if(usuario != null){
            Moderador resultModerador = new Moderador(usuario.getId(), usuario.getApelido(), usuario.getUsername(),usuario.getPassword(),usuario.getRank(), 0);
            resultModerador.setRank(1900);
            moderadorRepository.save(resultModerador);
            return resultModerador;
        }else{
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não existe Usuário com o id = " + id);
        }
    }
}