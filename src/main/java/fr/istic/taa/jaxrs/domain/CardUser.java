package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "fiche_user")
public class CardUser {

    private Long id;
    private Date dateDassignation;
    private Date dateRetrait;
    private Date dateDebut;
    private Date dateFin;
    private User user;
    private Card card;

    public CardUser() {
        this.setDateDassignation(new Date());
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDassignation() {
        return dateDassignation;
    }

    public void setDateDassignation(Date dateDassignation) {
        this.dateDassignation = dateDassignation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    @ManyToOne
    @JsonBackReference("userRef")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JsonBackReference("cardRef")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
