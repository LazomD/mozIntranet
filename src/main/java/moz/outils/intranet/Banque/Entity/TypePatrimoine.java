package moz.outils.intranet.Banque.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypePatrimoine {

    @Id
    @GeneratedValue
    public Integer id;
    public String name;

    public TypePatrimoine() {
    }

    public TypePatrimoine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
