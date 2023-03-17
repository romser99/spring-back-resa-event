package fr.solutec.resaevent.a_evenement_type.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {

    @Id
    private int id;
    private String nom;

    public Type() {
    }

    public Type(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
