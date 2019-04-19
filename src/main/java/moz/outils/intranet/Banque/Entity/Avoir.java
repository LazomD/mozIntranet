package moz.outils.intranet.Banque.Entity;

import javax.persistence.*;

@Entity
public class Avoir {

    public Avoir() {
    }

    public Avoir(Integer userId, TypePatrimoine typePatrimoine, AvoirTimestamp avoirTimestamp, Double montant) {
        this.userId = userId;
        this.typePatrimoine = typePatrimoine;
        this.avoirTimestamp = avoirTimestamp;
        this.montant = montant;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "type_patrimoine_id")
    private TypePatrimoine typePatrimoine;

    @ManyToOne
    @JoinColumn(name = "avoir_timestamp_id")
    private AvoirTimestamp avoirTimestamp;
    private Double montant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public TypePatrimoine getTypePatrimoine() {
        return typePatrimoine;
    }

    public void setTypePatrimoine(TypePatrimoine typePatrimoine) {
        this.typePatrimoine = typePatrimoine;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public AvoirTimestamp getAvoirTimestamp() {
        return avoirTimestamp;
    }

    public void setAvoirTimestamp(AvoirTimestamp avoirTimestamp) {
        this.avoirTimestamp = avoirTimestamp;
    }
}
