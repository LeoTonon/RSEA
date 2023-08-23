package br.rsea.model;

import java.time.LocalDate;

public class Postagem {
    protected LocalDate data;
    protected int curtidas;
    
    public Postagem(LocalDate data, int curtidas) {
        this.data = data;
        this.curtidas = curtidas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    
}
