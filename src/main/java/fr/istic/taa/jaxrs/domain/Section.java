package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "section")
public class Section implements Serializable {

    private long idSection;
    private String libelle;
    private List<Card> fiches;
    private KanbanBoard kanbanBoard;

    public Section() {
    }

    public Section(long idSection, String libelle) {
        this.idSection = idSection;
        this.libelle = libelle;
    }

    public void setIdSection(long idSection) {
        this.idSection = idSection;
    }

    @Id
    @GeneratedValue
    public long getIdSection() {
        return idSection;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "section")
    public List<Card> getFiches() {
        return fiches;
    }

    public void setFiches(List<Card> fiches) {
        this.fiches = fiches;
    }

    @ManyToOne
    @JoinColumn(name = "board_id")
    @JsonIgnore
    public KanbanBoard getKanbanBoard() {
        return kanbanBoard;
    }

    public void setKanbanBoard(KanbanBoard kanbanBoard) {
        this.kanbanBoard = kanbanBoard;
    }

    @Override
    public String toString() {
        return "Section{" +
                "idSection=" + idSection +
                ", libelle='" + libelle + '\'' +
                ", fiches=" + fiches +
                ", kanbanBoard=" + kanbanBoard +
                '}';
    }
}
