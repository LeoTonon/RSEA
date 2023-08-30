package br.rsea.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Cadastro;
import br.rsea.model.CadastroDAO;

@RestController
public class ComunidadeController {
    //1. Acessar o repositório de Artes
    CadastroDAO dao = CadastroDAO.getInstance();
    /*
     * Endpoint para retornar a lista de todas as artes
     */

    @PostMapping("/criar/comunidade")
    String postComunidade(){
        //2. Usar o método que retorna todas Artes
        ArrayList<Cadastro> cads = dao.read();
        //3. Retornar a lista de Artes com return
        return cads+"\n";
    }
}
