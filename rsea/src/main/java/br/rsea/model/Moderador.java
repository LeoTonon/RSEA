package br.rsea.model;

import javax.persistence.Entity;

public class Moderador extends Usuario{
    private int id,reputacao;
    private static String status;

    @Entity
    public Moderador(String apelido, double rank, int id, int reputacao) {
        super(id, apelido, rank, status);
        this.id = id;
        this.reputacao = reputacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReputacao() {
        return reputacao;
    }

    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }
}
