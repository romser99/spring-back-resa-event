package fr.solutec.re.entites;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table( name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_type")
    private Type type;

    @JoinColumn(name = "id_salle")
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Salle salle;

    public Evenement() {
    }

    public Evenement(int id, String nom, String description, Type type, Salle salle) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.salle = salle;
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

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
