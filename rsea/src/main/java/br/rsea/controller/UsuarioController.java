package br.rsea.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Cadastro;
import br.rsea.model.CadastroDAO;

@RestController
public class UsuarioController {
    CadastroDAO dao = CadastroDAO.getInstance();

    @GetMapping("/usuarios")
    List<Cadastro> getusuariostest(){
        List<Cadastro> cads = dao.read();
        return cads;
    }

    @GetMapping("/usuarios/{id}")
    Cadastro getusuariosById(@PathVariable("id") int id){
        List<Cadastro> cads = dao.read();
        try {
            return cads.get(id-1);
        }catch(Exception e){
            return null;
        }
        
    }
}
