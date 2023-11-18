package br.rsea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
