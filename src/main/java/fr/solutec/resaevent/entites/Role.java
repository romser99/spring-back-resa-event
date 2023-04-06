package fr.solutec.resaevent.entites;



import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    public String libelle ;

    public Role(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }

    public Role(int id) {
        this.id = id;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
