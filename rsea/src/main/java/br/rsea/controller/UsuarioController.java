package br.rsea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Cadastro;
import br.rsea.model.CadastroDAO;
import br.rsea.model.Usuario;

@RestController
public class UsuarioController {
    //1. Acessar o repositório de Artes
    CadastroDAO dao = CadastroDAO.getInstance();
    /*
     * Endpoint para retornar a lista de todas as artes
     */
    @GetMapping("/usuarios")
    List<Cadastro> getusuariostest(){
        //2. Usar o método que retorna todas Artes
        List<Cadastro> cads = dao.read();
        //3. Retornar a lista de Artes com return
        return cads;
    }

    @GetMapping("/usuarios/{id}")
    Cadastro getusuariosById(@PathVariable("id") int id){
        //2. Usar o método que retorna todas Artes
        List<Cadastro> cads = dao.read();
        //3. Retornar a lista de Artes com return
        try {
            return cads.get(id-1);
        }catch(Exception e){
            return null;
        }
        
    }
}
