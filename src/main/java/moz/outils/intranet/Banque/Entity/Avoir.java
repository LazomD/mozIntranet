package moz.outils.intranet.Banque.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Avoir {

    public Avoir(Integer userId, Integer typeId, Integer timestamp, Double montant) {
        this.userId = userId;
        this.typeId = typeId;
        this.timestamp = timestamp;
        this.montant = montant;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer typeId;
    private Integer timestamp;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
