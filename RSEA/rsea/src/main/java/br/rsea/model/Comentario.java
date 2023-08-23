package br.rsea.model;

public class Comentario {
    protected String conteudo;
    protected int curtidas;
    
    public Comentario(String conteudo, int curtidas) {
        this.conteudo = conteudo;
        this.curtidas = curtidas;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    
}
