package fr.solutec.re.entites;

import javax.persistence.*;

@Entity
@Table(name = "lieu")

public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    public String nom ;
    @OneToOne
    private Adresse adresse;

    public Lieu(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Lieu(int id, String nom, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Lieu() {

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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
