package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "fiche_user")
public class FicheUser {

    private Long id;
    private Date dateDassignation;
    private Date dateRetrait;
    private Date dateDebut;
    private Date dateFin;

    public FicheUser() {
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
}
