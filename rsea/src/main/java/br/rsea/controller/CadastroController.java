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

@RestController
public class CadastroController {
    @Autowired
    
    @GetMapping("/cadastro")
    List<Cadastro> getCadastros(){
        CadastroDAO dao = CadastroDAO.getInstance();
        List<Cadastro> cads = dao.read();
        return cads;
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
    List<Moderador> getModeradores(){
        ModeradorDAO dao = ModeradorDAO.getInstance();
        List<Moderador> mods = dao.read();
        return mods;
    }

    @PostMapping("/criar/usuario")
    Usuario newUsuario(@RequestBody Usuario newUsuario){
        CadastroDAO cads = CadastroDAO.getInstance();
        cads.create(newUsuario);
        return newUsuario;
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

