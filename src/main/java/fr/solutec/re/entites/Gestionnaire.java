package fr.solutec.re.entites;

public class Gestionnaire extends Personne{

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
