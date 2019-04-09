package moz.outils.intranet.Banque.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AvoirTimestamp {

    public AvoirTimestamp() {
    }

    public AvoirTimestamp(Integer userId, Integer timestamp) {
        this.userId = userId;
        this.timestamp = timestamp;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer timestamp;

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

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
