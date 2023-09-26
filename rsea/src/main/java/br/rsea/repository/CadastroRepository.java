package br.rsea.repository;

import org.springframework.data.repository.CrudRepository;

import br.rsea.model.Usuario;

public interface CadastroRepository extends CrudRepository<Usuario, Integer>{
    
}
