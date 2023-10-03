package br.rsea.repository;

import org.springframework.data.repository.CrudRepository;

import br.rsea.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
