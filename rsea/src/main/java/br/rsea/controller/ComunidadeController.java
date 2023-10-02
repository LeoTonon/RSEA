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
import br.rsea.model.ComunidadeDAO;
import br.rsea.repository.ComunidadeRepository;

@RestController
public class ComunidadeController {
    @Autowired
    ComunidadeRepository comunidadeRepository;
    ComunidadeDAO dao = ComunidadeDAO.getInstance();
    List<Comunidade> cads = dao.read();
    int comunidadeLugar=0;

    @PostMapping("/criar/comunidade")
    public Comunidade postComunidade(@RequestBody Comunidade comu){
        dao.create(comu);
        return (Comunidade) comunidadeRepository.findAll();
    }

    @GetMapping("/comunidade")
    List<Comunidade> getComunidade(){
        return (List<Comunidade>) comunidadeRepository.findAll();
    }

    // @DeleteMapping("/{comunidade}/{id}")
    // public List<Comunidade> delIntegrantes( @PathVariable("comunidade") String comunidade, @PathVariable("id") int id){
    //     setarCaminhoComu(comunidade, id);
    //     try {
    //         for(int i=0 ; i<dao.read().get(comunidadeLugar).getLista().size() ; i++){
    //             if(dao.read().get(comunidadeLugar).getLista().get(i).getId() == id){
    //                 dao.read().get(comunidadeLugar).getLista().remove(i);
    //             }
    //         }
    //         return cads; 
    //     } catch (Exception e) {
    //         return cads; 
    //     }     
    // }

    public void setarCaminhoComu (String comunidade, int comunidadeLugar){
        try {
            for(int k=0 ; k<dao.read().size() ; k++){
                if(dao.read().get(k).getTituloComu().equals(comunidade)){
                    comunidadeLugar = k;
                }
            }
        } catch (Exception e) {
            System.out.println("Não tem nenhuma comunidade criada!");
        }
    }
}
