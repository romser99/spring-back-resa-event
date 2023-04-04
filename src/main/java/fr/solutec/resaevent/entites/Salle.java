package fr.solutec.resaevent.entites;
import javax.persistence.*;
@Entity
@Table(name = "SALLE")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int capacite;
    @OneToOne
    @JoinColumn (name="id_lieu")
    private Lieu lieu;
    public Salle() {
    }

    public Salle(int id, String nom, int capacite, Lieu lieu) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.lieu = lieu;
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
}