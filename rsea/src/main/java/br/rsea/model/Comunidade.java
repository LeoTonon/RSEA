package br.rsea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String tituloComu, descricao;

    public Comunidade() {

    }

    public Comunidade(String tituloComu, String descricao) {
        this.tituloComu = tituloComu;
        this.descricao = descricao;
    }

    public String getTituloComu() {
        return tituloComu;
    }

    public void setTituloComu(String tituloComu) {
        this.tituloComu = tituloComu;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return tituloComu + " " + descricao;
    }

}
