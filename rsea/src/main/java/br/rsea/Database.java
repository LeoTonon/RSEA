package br.rsea; 

import java.util.ArrayList;

import br.rsea.model.Cadastro;
import br.rsea.model.Comunidade;
import br.rsea.model.Usuario;

public class Database {
    public ArrayList<Cadastro> cadastros;
    public ArrayList<Comunidade> comunidade;

    public Database() {
        cadastros = new ArrayList<>();
        // Usuario usuario = new Usuario(1, "Usuário1", 1, "ok");
        // cadastros.add(usuario);
        // cadastros.add( new Usuario(2, "Usuário2", 1, "ok"));
        // cadastros.add( new Usuario(3, "Usuário3", 1, "ok"));
        comunidade = new ArrayList<>();
        // Comunidade comu1 = new Comunidade("Comunidade 1", "Desc Comunidade 1");
        // comu1.addUsuario(usuario);
        // comunidade.add(comu1);
        // comunidade.add( 
        //     new Comunidade("Comunidade 1", "Desc Comunidade 1"));
        // comunidade.add( 
        //     new Comunidade("Comunidade 2", "Desc Comunidade 2"));
    } 

    public ArrayList<Cadastro> recuperaCad() {
        return cadastros;
    }
    
    public void addCad(Cadastro novo) {
        cadastros.add(novo);
    }
    
    public void delCad(int index){
        cadastros.remove(index);
    }

    public int readCad(){
        return cadastros.size();
    }

    public ArrayList<Comunidade> recuperaCom() {
        return comunidade;
    }
    public void addCom(Comunidade novo) {
        comunidade.add(novo);
    }

    public int readCom(){
        return comunidade.size();
    }
}
