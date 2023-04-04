package fr.solutec.resaevent.entites;
import javax.persistence.*;

@Entity
@Table(name = "LIEU")
public class Lieu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToOne
    @JoinColumn (name="id_adresse")
    private Adresse adresse;

    public Lieu(){}

    public Lieu(int id, String nom, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
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

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    public Adresse getAdresse() {
        return adresse;
    }
}
