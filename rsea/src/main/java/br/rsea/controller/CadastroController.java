package br.rsea.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Cadastro;
import br.rsea.model.CadastroDAO;

@RestController
public class CadastroController {

    @GetMapping("/cadastro")
    List<Cadastro> getCadastros(){
        CadastroDAO dao = CadastroDAO.getInstance();
        List<Cadastro> cads = dao.read();
        return cads;
    }
}
