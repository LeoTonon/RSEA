package br.rsea.model;

public class Cadastrado extends Cadastro{

    public Cadastrado(String nome, String telefone, String genero, String email, String senha) {
        this.nome = getNome();
        this.telefone = getTelefone();
        this.genero = getGenero();
        this.email = getEmail();
        this.senha = getSenha();
    }

    @Override
    void alterarPost() {
        
    }

    @Override
    public String toString() {
        return getNome()+" "+getTelefone()+" "+getGenero()+" "+getEmail()+" "+getSenha();
    }
}
