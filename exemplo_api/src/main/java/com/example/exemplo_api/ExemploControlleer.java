package com.example.exemplo_api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploControlleer {

    @GetMapping("/exemplo")
    public String endPoint1() {
        return "Exemplo API Rest";
    }

    // localhost:8080/exemplo/99
    @GetMapping("/exemplo/{parametro}")
    public String endPoint2(@PathVariable("parametro") Long valor) {
        // Algoritmo de acesso ao Banco de dados
        return "Parâmetros recebido: " + valor;
    }

    @PostMapping("/exemplo/inserir")
    public User endPoint2(@RequestBody User user) {
        // Algoritmo de acesso ao Banco de dados
        return user;
    }

    @PutMapping("/exemplo/atualizar")
    public User endPoint4(@RequestBody User objetoParaAtualizar) {
        return objetoParaAtualizar;
    }

    @DeleteMapping("/exemplo/remove/{id}")
    public String endPoint5(@PathVariable("id") Long id) {
        if (id == 1)
            return "Remoção de informação com id " + id + " realizada";
        else {
            return "Objeto para id " + id + "não encontrado";
        }
    }
}
