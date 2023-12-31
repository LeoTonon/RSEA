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
            return comunidadeRepository.save(comu);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/listar/comunidades")
    List<Comunidade> getComunidade(){
        List<Comunidade> comunidades = (List<Comunidade>) comunidadeRepository.findAll();
        return comunidades; 
    }

    @DeleteMapping("/{comunidade}/{id}")
    Comunidade deleteComunidade(@RequestBody Comunidade comu, @PathVariable int id){
        Comunidade comunidade = (comunidadeRepository.findById(id).get());
        if(comunidade.getTituloComu().equals(comu.getTituloComu())){
            comunidadeRepository.deleteById(id);
            return (Comunidade) comunidadeRepository.findAll();
        }

        return null;
    }
}