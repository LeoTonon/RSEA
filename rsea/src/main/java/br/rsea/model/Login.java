package br.rsea.model;

public class Login {
    private String apelido, senha;

    public Login(String apelido, String senha) {
        this.apelido = apelido;
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
