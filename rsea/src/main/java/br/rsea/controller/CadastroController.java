package br.rsea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    UsuarioRepository usuarioRepository;
    @Autowired
    ModeradorRepository moderadorRepository;
    
    @GetMapping("/cadastro")
    public List<Usuario> getCadastros(){
        return (List<Usuario>)usuarioRepository.findAll();
    }

    @GetMapping("/cadastro/{id}")
    Optional<Usuario> getusuariosById(@PathVariable("id") int id){
        return usuarioRepository.findById(id);
        // (usuarioRepository.findById(id)).save(newModerador);
    }

    @GetMapping("/listar/moderadores")
    public List<Moderador> getModeradores(){
        return (List<Moderador>)moderadorRepository.findAll();
    }

    @PostMapping("/criar/usuario")
    Usuario newUsuario(@RequestBody Usuario newUsuario){
        usuarioRepository.save(newUsuario);
        return newUsuario;
    }

    @PutMapping("/moderador/{id}")
    Moderador newModerador(@PathVariable int id){
        Usuario usuario = (usuarioRepository.findById(id)).get();
        if(usuario != null){
            Moderador resultModerador = new Moderador(usuario.getApelido(), usuario.getRank(), usuario.getId(), 0);
            resultModerador.setRank(1900);
            moderadorRepository.save(resultModerador);
            return resultModerador;
        }else{
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não existe Usuário com o id = " + id);
        }
    }
}

