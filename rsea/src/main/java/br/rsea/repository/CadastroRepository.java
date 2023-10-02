package br.rsea.repository;

import org.springframework.data.repository.CrudRepository;

import br.rsea.model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Integer>{
    
}
