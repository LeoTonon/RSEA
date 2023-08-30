package br.rsea.model;

import java.util.ArrayList;

public class Usuario extends Cadastro implements Editor {
    public String apelido, status;
    public double rank;
    public int id;

    ArrayList<Arte> producoes = new ArrayList<>();
    ArrayList<Postagem> postagens = new ArrayList<>();

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

    public ArrayList<Arte> getProducoes() {
        return producoes;
    }

    public void setProducoes(ArrayList<Arte> producoes) {
        this.producoes = producoes;
    }

    public ArrayList<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(ArrayList<Postagem> postagens) {
        this.postagens = postagens;
    }

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
            return  new Moderador(this.apelido, this.rank, 0, 0);
        }
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
}
