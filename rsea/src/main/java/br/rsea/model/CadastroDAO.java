package br.rsea.model;

import java.util.ArrayList;

// import org.springframework.stereotype.Service;

import br.rsea.Database;

// @Service
public class CadastroDAO {
    private Database db;
    private static CadastroDAO instance;

    public CadastroDAO(){

    }

    // public static CadastroDAO getInstance(){
    //     if(instance == null){
    //         instance = new CadastroDAO();
    //     }
    //     return instance;
    // }

    // Recupera a conexão com o Banco de Dados
    private Database getConnection(){
        if(this.db == null){            
            Database db = new Database();
            this.db = db;
        }
        return this.db;    
    }


    //Cria um novo cadastro
    public void create(Usuario novo){
        Database db = getConnection();
        db.addCad(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Cadastro> read(){
        Database db = getConnection();
        return db.recuperaCad();
    }

    public void delete(int index){
        Database db = getConnection();
        db.delCad(index);
    }

    public Cadastro findById(Long id) {
        return this.read().get(id.intValue());
    }
}
