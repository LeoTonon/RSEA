package br.rsea.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.rsea.model.Comunidade;
import br.rsea.model.ComunidadeDAO;

@RestController
public class ComunidadeController {
    ComunidadeDAO dao = ComunidadeDAO.getInstance();
    List<Comunidade> cads = dao.read();

    @PostMapping("/criar/comunidade")
    public Comunidade postComunidade(@RequestBody Comunidade comu){
        dao.create(comu);
        return comu;
    }

    @GetMapping("/comunidade")
    List<Comunidade> getComunidade(){
        return cads;
    }

    @DeleteMapping("/{comunidade}/{id}")
    public List<Comunidade> delIntegrantes( @PathVariable("comunidade") String comunidade, @PathVariable("id") int id){
            //2
            /*
                dao.read() é de 0 a n;
                dao.read().get(0).getLista().size() é de 0 a n;
                */
                int comunidadeLugar=0;
                for(int k=0 ; k<dao.read().size() ; k++){
                    if(dao.read().get(k).getTituloComu().equals(comunidade)){
                        comunidadeLugar = k;
                    }
                }
                for(int i=0 ; i<dao.read().get(comunidadeLugar).getLista().size() ; i++){
                    if(dao.read().get(comunidadeLugar).getLista().get(i).getId() == id){
                        System.out.println(dao.read().get(comunidadeLugar).getLista().size()); 
                        dao.read().get(comunidadeLugar).getLista().remove(i);
                        System.out.println("ASUHASHSDAIYHUASDIHUASD");
                        System.out.println(dao.read().get(comunidadeLugar).getLista().size()); 
                        System.out.println("foi?");
                    }
                    System.out.println("testes");
                }
                    return cads;   
    }
}
