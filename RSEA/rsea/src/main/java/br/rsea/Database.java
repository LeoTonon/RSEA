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
        cadastros.add( new Usuario(1, "ok", 1, "ok"));
        cadastros.add( new Usuario(1, "ok", 1, "ok"));
        cadastros.add( new Usuario(1, "ok", 1, "ok"));
        comunidade = new ArrayList<>();
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
