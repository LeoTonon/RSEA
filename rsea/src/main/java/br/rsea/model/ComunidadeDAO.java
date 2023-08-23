package br.rsea.model;

import java.util.ArrayList;

import br.rsea.Database;

public class ComunidadeDAO {
    private Database db;
    private static ComunidadeDAO instance;

    public ComunidadeDAO(){

    }

    public static ComunidadeDAO getInstance(){
        if(instance == null){
            instance = new ComunidadeDAO();
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

    public void addDB(Comunidade novo) {
        db.comunidade.add(novo);
    }

    //Cria um novo cadastro
    public void create(Comunidade novo){
        Database db = getConnection();
        db.addCom(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Comunidade> read(){
        Database db = getConnection();
        return db.recuperaCom();
    }

    public void delete(Cadastro deletar){
        db.comunidade.remove(deletar);
    }

    public void update(int i, Cadastro toUpdate){
        db.cadastros.remove(i);
        db.cadastros.add(i, toUpdate);
    }
}


// public class ComunidadeDAO {
//     protected String tituloComu,descricao;
//     ArrayList<Usuario> lista = new ArrayList<>();

//     public void adicionarUsuario(Usuario usuario) {
//         lista.add(usuario);
//         System.out.println("Usuário "+usuario.getApelido()+" adicionado!\n"+lista);
//     }

//     public void deletarUsuario(Usuario usuario) {
//         lista.remove(usuario);
//         System.out.println("Usuário "+usuario.getApelido()+" retirado!\n"+lista);
//     }
    
//     public void listarUsuarios() {
//         for(int i=0;i<lista.size();i++){
//             System.out.println(lista);
//         }
//     }
// }
