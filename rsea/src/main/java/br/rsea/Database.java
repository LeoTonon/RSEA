package br.rsea; 

import java.util.ArrayList;

import br.rsea.model.Cadastro;
import br.rsea.model.Comunidade;
import br.rsea.model.Moderador;

public class Database {
    public ArrayList<Cadastro> cadastros;
    public ArrayList<Comunidade> comunidade;
    public ArrayList<Moderador> moders;

    public Database() {
        cadastros = new ArrayList<>();
        comunidade = new ArrayList<>();
        moders = new ArrayList<>();
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

    public void addMod(Moderador moderador){
        moders.add(moderador);
    }

    public ArrayList<Comunidade> recuperaCom() {
        return comunidade;
    }

    public ArrayList<Moderador> recuperaMod() {
        return moders;
    }

    public void addCom(Comunidade novo) {
        comunidade.add(novo);
        
    }

    public int readCom(){
        return comunidade.size();
    }
}
