package br.rsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Comunidade;
import br.rsea.repository.ComunidadeRepository;

@RestController
public class ComunidadeController {
    @Autowired
    ComunidadeRepository comunidadeRepository;

    @PostMapping("/criar/comunidade")
    public Comunidade postComunidade(@RequestBody Comunidade comu){
        try {
            comunidadeRepository.save(comu);
            return (Comunidade) comunidadeRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/comunidade")
    List<Comunidade> getComunidade(){
        return (List<Comunidade>) comunidadeRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public Comunidade delIntegrantes(@PathVariable("id") int id){
        try {
            comunidadeRepository.deleteById(id);
            return (Comunidade) comunidadeRepository.findAll();
        } catch (Exception e) {
            return null; 
        }     
    }
}
