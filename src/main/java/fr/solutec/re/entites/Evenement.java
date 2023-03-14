package fr.solutec.re.entites;

import java.util.Date;

public class Evenement {
    private int id;
    private String nom;
    private String description;

    private Date date;

    private Type type;


    public Evenement() {
    }

    public Evenement(int id, String nom, String description, Date date, Type type) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
