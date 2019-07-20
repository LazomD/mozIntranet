package moz.outils.intranet.Banque.Entity;

import javax.persistence.*;

@Entity
public class Eleve {

    public Eleve() {
    }

    public Eleve(String prenom, Classe classe) {
        this.prenom = prenom;
        this.classe = classe;
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String prenom;


    @ManyToOne(fetch = FetchType.LAZY)
    private Classe classe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
