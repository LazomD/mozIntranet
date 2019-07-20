package moz.outils.intranet.Banque.Entity;

import javax.persistence.*;

@Entity
public class MatchRempla {

    public MatchRempla() {
    }


    @Id
    @GeneratedValue
    private Integer id;
    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    private Eleve eleve1;

    @OneToOne
    private Eleve eleve2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Eleve getEleve1() {
        return eleve1;
    }

    public void setEleve1(Eleve eleve1) {
        this.eleve1 = eleve1;
    }

    public Eleve getEleve2() {
        return eleve2;
    }

    public void setEleve2(Eleve eleve2) {
        this.eleve2 = eleve2;
    }
}
