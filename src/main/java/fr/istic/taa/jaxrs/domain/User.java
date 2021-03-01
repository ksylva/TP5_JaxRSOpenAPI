package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity(name = "user")
public class User implements Serializable {

    private long idUser;
    private String name;
    private boolean enabled;
    private List<Fiche> fiches;

    public User() {
        this.setEnabled(true);
    }

    public User(long idUser, String name) {
        this.idUser = idUser;
        this.name = name;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Id
    @GeneratedValue
    public long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return name;
    }
}
