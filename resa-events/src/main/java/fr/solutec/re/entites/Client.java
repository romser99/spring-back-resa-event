package fr.solutec.re.entites;

public class Client extends Personne{
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
