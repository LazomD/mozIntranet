package moz.outils.intranet.Banque.DTO;

public class MesureDTO {

    public Double montant;
    public Integer timestamp;

    public MesureDTO(Double montant, Integer timestamp) {
        this.montant = montant;
        this.timestamp = timestamp;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
