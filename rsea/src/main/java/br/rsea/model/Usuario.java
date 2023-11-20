package br.rsea.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String apelido;
    public String status;
    public String username;
    public String password;
    @Column(name = "user_rank", nullable = false)  // Renomeie a coluna para evitar conflitos com palavras reservadas
    public double userRank;

    public Usuario() {
    }

    public Usuario(int id,String username,String password,String apelido, double rank,String status) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.apelido = apelido;
        this.userRank = rank;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRank() {
        return userRank;
    }

    public void setRank(double rank) {
        this.userRank = rank;
    }
}
