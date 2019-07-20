package moz.outils.intranet.Banque.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Classe {

    public Classe() {
    }

    public Classe(String nom, String etablissement) {
        this.nom = nom;
        this.etablissement = etablissement;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String etablissement;

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

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }
}
