package br.rsea.model;

public class Arte {
    protected String tipo;
    protected int pontuacao;
    
    public Arte(String tipo, int pontuacao) {
        this.tipo = tipo;
        this.pontuacao = pontuacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    
}
