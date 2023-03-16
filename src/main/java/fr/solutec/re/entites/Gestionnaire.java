package fr.solutec.re.entites;

import javax.persistence.*;

@Entity
@Table(name = "gestionnaire")
public class Gestionnaire extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Gestionnaire(int id) {
        this.id = id;
    }

    public Gestionnaire(String prenom, String nom, String email, String telephone, String password, int id) {
        super(prenom, nom, email, telephone, password);
        this.id = id;
    }

    public Gestionnaire() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
