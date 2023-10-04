package br.rsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Cadastro;
import br.rsea.model.CadastroDAO;
import br.rsea.model.Moderador;
import br.rsea.model.ModeradorDAO;
import br.rsea.model.Usuario;
import br.rsea.repository.UsuarioRepository;

@RestController
public class CadastroController {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/cadastro")
    public List<Cadastro> getCadastros(){
        return (List<Cadastro>)UsuarioRepository.findAll();
    }

    @GetMapping("/cadastro/{id}")
    Cadastro getusuariosById(@PathVariable("id") int id){
        CadastroDAO dao = CadastroDAO.getInstance();
        List<Cadastro> cads = dao.read();
        try {
            return cads.get(id-1);
        }catch(Exception e){
            return null;
        }
        
    }

    @GetMapping("/listar/moderadores")
    public List<Moderador> getModeradores(){
        return (List<Moderador>)ModeradorRepository.findAll();
    }

    @PostMapping("/criar/usuario")
    Usuario newUsuario(@RequestBody Usuario newUsuario){
        return UsuarioRepository.save(newUsuario);
        UsuarioRepository.findAll();
    }

    @PutMapping("/moderador")
    Usuario tornaMod(@RequestBody Usuario newUsuario) {
        CadastroDAO cads = CadastroDAO.getInstance();
        ModeradorDAO mods = ModeradorDAO.getInstance();
        Usuario userUpdate = (Usuario) cads.findById(Long.valueOf(newUsuario.getId()));
        userUpdate.updateRank();
        return userUpdate;
    }
    /*
     * 1. Puxa o id do usuário
     * 2. Puxa o updateRank
     * 3. Atualiza o rank
     * 4. Cria novo moderador
     * 5. Retorna tando o User quanto o Mod criado 
     */
}

