package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "user")
public class User implements Serializable {

    private long idUser;
    private String name;
    private boolean enabled;
    private List<CardUser> fiches;

    public User() {
        this.setEnabled(true);
    }

    public User(String name) {
        this.idUser = this.getIdUser();
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

    @OneToMany(mappedBy = "card"/*cascade = CascadeType.ALL*/)
    //@JoinColumn(name = "user_id")
    //@JsonManagedReference
    public List<CardUser> getFiches() {
        return fiches;
    }

    public void setFiches(List<CardUser> fiches) {
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

    /*private Card fiches2;

    @ManyToOne(optional = false)
    public Card getFiches2() {
        return fiches2;
    }

    public void setFiches2(Card fiches2) {
        this.fiches2 = fiches2;
    }*/
}
