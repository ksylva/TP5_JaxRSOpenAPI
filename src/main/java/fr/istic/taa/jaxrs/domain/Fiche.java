package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "fiche")
public class Fiche implements Serializable {

    private long idFiche;
    private Date dateButoire;
    private int duree;
    private String lieu;
    private String url;
    private String note;
    private FicheUser user;
    private List<Tag> tags;
    private Section section;
    private boolean enabled;

    public Fiche() {
        this.setEnabled(true);
    }

    public Fiche(Date dateButoire,
                 int duree, String lieu, String url,
                 String note, FicheUser user, List<Tag> tags, Section section) {
        this.idFiche = getIdFiche();
        this.dateButoire = dateButoire;
        this.duree = duree;
        this.lieu = lieu;
        this.url = url;
        this.note = note;
        this.user = user;
        this.tags = tags;
        this.section = section;
    }

    public void setIdFiche(long idFiche) {
        this.idFiche = idFiche;
    }

    @Id
    @GeneratedValue
    public long getIdFiche() {
        return idFiche;
    }

    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @OneToMany
    //@JsonBackReference
    public List<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @ManyToOne
    //@JsonIgnore()
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        String str = "Fiche: \n" +
                "Date butoire: " + dateButoire +'\n'+
                "Duree: " + duree +"\n"+
                "Lieu: " + lieu + "\n" +
                "Url: " + url + "\n" +
                "Remarque: " + note + "\n" +
                "User: " + user +"\n" +
                "Tags: " + tags +"\n" +
                "";
        return str;
    }
}
