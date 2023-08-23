package br.rsea.model;

import java.util.ArrayList;

public class Comunidade {
    protected String tituloComu,descricao;
    ArrayList<Usuario> lista = new ArrayList<>();

    public Comunidade(String tituloComu, String descricao, ArrayList<Usuario> lista) {
        this.tituloComu = tituloComu;
        this.descricao = descricao;
        this.lista = lista;
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
        return tituloComu+" "+descricao;
    }

}
