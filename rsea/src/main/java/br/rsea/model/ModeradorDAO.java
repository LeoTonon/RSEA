package br.rsea.model;
import java.util.ArrayList;
import br.rsea.Database;

public class ModeradorDAO {
    private Database db;
    private static ModeradorDAO instance;
    
    public ModeradorDAO(){
    
    }

    public void create(Moderador novo){
        Database db = getConnection();
        db.addMod(novo);
    }   

    public static ModeradorDAO getInstance(){
        if(instance == null){
            instance = new ModeradorDAO();
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

    public ArrayList<Moderador> read(){
        Database db = getConnection();
        return db.recuperaMod();
    }
    }
