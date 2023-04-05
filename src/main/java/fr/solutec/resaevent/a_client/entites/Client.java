package fr.solutec.resaevent.a_client.entites;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Client(String prenom, String nom, String email, String telephone, String password, int id) {
        super(prenom, nom, email, telephone, password);
        this.id = id;
    }

    public Client(int id) {
        this.id = id;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
