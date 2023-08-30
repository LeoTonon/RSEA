package br.rsea.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/comunidade")
    String getcomunidade(){
        //2. Usar o método que retorna todas Artes
        ArrayList<Cadastro> cads = dao.read();
        //3. Retornar a lista de Artes com return
        return cads+"\n";
    }

    @GetMapping("/comunidade/{id}")
    String getcomunidadeById(@PathVariable("id") int id){
        //2. Usar o método que retorna todas Artes
        ArrayList<Cadastro> cads = dao.read();
        //3. Retornar a lista de Artes com return
        try {
            return cads.get(id-1)+"";
        }catch(Exception e){
            return "O ID não foi encontrado em usuários!";
        }
        
    }
}
