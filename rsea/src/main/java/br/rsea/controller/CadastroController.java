package br.rsea.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Cadastro;
import br.rsea.model.CadastroDAO;

@RestController
public class CadastroController {
    /*
     * Endpoint para retornar a lista de todas as artes
     */
    @GetMapping("/cadastro")
    List<Cadastro> getCadastros(){
        //1. Acessar o repositório de Artes
        CadastroDAO dao = CadastroDAO.getInstance();
        //2. Usar o método que retorna todas Artes
        List<Cadastro> cads = dao.read();
        //3. Retornar a lista de Artes com return
        return cads;
    }

    @GetMapping("/teste")
    String getTexto(){
        return "Teste";
    }
}
