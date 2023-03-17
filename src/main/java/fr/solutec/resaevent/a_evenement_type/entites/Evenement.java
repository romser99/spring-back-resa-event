package fr.solutec.resaevent.a_evenement_type.entites;

import javax.persistence.*;


@Entity
@Table( name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Type type;

    public Evenement() {
    }

    public Evenement(int id, String nom, String description, Type type) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
