package fr.istic.taa.jaxrs.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "tableau")
public class KanbanBoard implements Serializable {

    private long idKanbanBoard;
    private String name;
    //private String tableSlug;
    private List<Section> sections;

    public KanbanBoard() {
        //this.tableSlug = this.getName()+"-"+this.getIdKanbanBoard();
    }
    /*List<Section> sections,*/
    public KanbanBoard(String name) {
        this.idKanbanBoard = getIdKanbanBoard();
        //this.sections = sections;
        this.name = name;
        //this.tableSlug = this.name+"-"+this.getIdKanbanBoard();
    }

    public void setIdKanbanBoard(long idKanbanBoard) {
        this.idKanbanBoard = idKanbanBoard;
    }

    @Id
    @GeneratedValue/*(strategy = GenerationType.IDENTITY)*/
    public long getIdKanbanBoard() {
        return idKanbanBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //String slug = name.replace(" ", "-");
        //this.tableSlug = slug +"-"+(this.idTableau);
    }


    /*public String getTableSlug() {
        return tableSlug;
    }

    public void setTableSlug(String tableSlug) {
        this.tableSlug = tableSlug;
        //this.tableSlug = this.getName()+"-"+this.getIdKanbanBoard();
    }*/

    @OneToMany(mappedBy = "kanbanBoard", cascade = CascadeType.PERSIST)
    //@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> fiches) {
        this.sections = fiches;
    }


    @Override
    public String toString() {
        return "KanbanBoard{" +
                "name='" + name + '\'' +
                '}';
    }
}
