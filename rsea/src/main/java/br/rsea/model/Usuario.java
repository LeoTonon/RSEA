package br.rsea.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String apelido;
    public String status;
    @Column(name = "rank", nullable = false)
    public double rank;

    public Usuario() {
    }

    public Usuario(int id,String apelido, double rank,String status) {
        super();
        this.id = id;
        this.apelido = apelido;
        this.rank = rank;
        this.status = status;
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
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    // public Moderador tornarModerador(){
    //     if(this.rank >= 1900){
    //         System.out.println("Você se tornou moderador! Meus parabéns!");
    //         Moderador moderna = new Moderador(this.getApelido(), this.getRank(), this.getId(), 0);
    //         ModeradorDAO mod = new ModeradorDAO().getInstance();
    //         mod.create(moderna);
    //         return moderna;
    //     }
    //     return null;
    // }

    // public Moderador updateRank(){
    //     double novoRank = ((1900 - this.getRank()) + this.getRank());
    //     this.setRank(novoRank);
    //     if (novoRank >= 1900) {
    //         return tornarModerador();    
    //     };        
    //     return null;
    // };
}
