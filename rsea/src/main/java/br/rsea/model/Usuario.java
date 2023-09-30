package br.rsea.model;

//import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario extends Cadastro implements Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String apelido, status;
    public double rank;

    // ArrayList<Arte> producoes = new ArrayList<>();
    // ArrayList<Postagem> postagens = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(int id,String apelido, double rank,String status) {
        this.id = id;
        this.apelido = apelido;
        this.rank = rank;
        this.status = status;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // public ArrayList<Arte> getProducoes() {
    //     return producoes;
    // }

    // public void setProducoes(ArrayList<Arte> producoes) {
    //     this.producoes = producoes;
    // }

    // public ArrayList<Postagem> getPostagens() {
    //     return postagens;
    // }

    // public void setPostagens(ArrayList<Postagem> postagens) {
    //     this.postagens = postagens;
    // }

    @Override
    public
    void alterarPost() {
       
        
    }

    @Override
    public void editarComunidade() {
        

    }

    @Override
    public void editarUsuario() {
        
    }

    @Override
    public void status() {
        if(rank <= 1000){
            System.out.println(NOVATO);
        }
        if(rank > 1000 && rank <= 2000){
            System.out.println(INTER);
        }
        if(rank > 2000){
            System.out.println(PRO);
        }
    }

    public Moderador tornarModerador(){
        if(this.rank >= 1900){
            System.out.println("Você se tornou moderador! Meus parabéns!");
            Moderador moderna = new Moderador(this.getApelido(), this.getRank(), this.getId(), 0);
            ModeradorDAO mod = new ModeradorDAO().getInstance();
            mod.create(moderna);
            return moderna;
        }
        return null;
    }

    private Moderador Moderador(String apelido2, double rank2, int i, int j) {
        return null;
    }

    @Override
    public String toString(){
        if(getRank() <= 1000){
            return "ID:"+getId()+ " Usuário: "+getApelido()+" | Rank: "+getRank()+" NOVATO";
        }
        if(getRank() > 1000 && getRank() <= 2000){
            return "ID:"+getId()+ " Usuário: "+getApelido()+" | Rank: "+getRank()+" AMADOR";
        }
        if(getRank() > 2000){
            return "ID:"+getId()+ " Usuário: "+getApelido()+" | Rank: "+getRank()+" PRO";
        }
        return null;
    }
    
    public Moderador updateRank(){
        double novoRank = ((1900 - this.getRank()) + this.getRank());
        this.setRank(novoRank);
        if (novoRank >= 1900) {
            return tornarModerador();    
        };        
        return null;
    };
}
