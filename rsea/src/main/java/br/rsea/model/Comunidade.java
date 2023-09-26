package br.rsea.model;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String tituloComu, descricao;

    List<Usuario> lista = new ArrayList<>();

    public Comunidade() {

    }

    public Comunidade(String tituloComu, String descricao) {
        this.tituloComu = tituloComu;
        this.descricao = descricao;
        this.lista = new ArrayList<>();
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

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return tituloComu + " " + descricao;
    }

    public void addUsuario(Usuario usuario) {
        lista.add(usuario);
    }

}
