package fr.solutec.resaevent.entites;
import javax.persistence.*;

@Entity
@Table(name = "PLACE")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categorie;
    private int prix;
    @OneToOne
    @JoinColumn(name="id_salle")
    private Salle salle;

    public Place() {
    }

    public Place(int id, String categorie, int quantite, int prix, Salle salle) {
        this.id = id;
        this.categorie = categorie;
        this.prix = prix;
        this.salle = salle;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
