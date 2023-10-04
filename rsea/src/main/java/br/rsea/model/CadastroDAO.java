package br.rsea.model;

import java.util.ArrayList;

import br.rsea.Database;

public class CadastroDAO {
    private Database db;
    private static CadastroDAO instance;

    public CadastroDAO(){

    }

    public static CadastroDAO getInstance(){
        if(instance == null){
            instance = new CadastroDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private Database getConnection(){
        if(this.db == null){            
            Database db = new Database();
            this.db = db;
        }
        return this.db;    
    }


    //Cria um novo cadastro
    // public void create(Usuario novo){
    //     Database db = getConnection();
    //     db.addCad(novo);
    // }   

    // Recupera todas as listas
    public ArrayList<Cadastro> read(){
        Database db = getConnection();
        return db.recuperaCad();
    }

    public void delete(int index){
        Database db = getConnection();
        db.delCad(index);
    }

    public void updateToUsuarios(ArrayList<Usuario> usus){
        Database db = getConnection();
        for(int i=0 ; i<db.cadastros.size() ; i++){
            Usuario usuario = new Usuario(i,db.cadastros.get(i).getNome(), 0,"");
            usus.add(usuario);
            System.out.println(usuario);
        }
    }
    public void updateToListView(ArrayList<Usuario> ususToListView, int index){
        Database db = getConnection();
        Usuario usuario = new Usuario(index,db.cadastros.get(index).getNome(), 0,"");
        ususToListView.add(usuario);
        System.out.println(usuario);
    }

    public Cadastro findById(Long id) {
        return this.read().get(id.intValue());
    }
}
